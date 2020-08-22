package com.bubble.hearthstone.ui.gui.panels;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.interfaces.ResizableDrawable;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net2.event.events.ChangeMenuEvent;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.ui.gui.DrawList;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ShopPanel extends Panel {

    private static final Color color = new Color(101, 42, 14);
    
    public ShopPanel(JFrame frame) {
        super(frame);
        pane.setBackground(color);
        initialize();
    }

    private void initialize() {
        pane.add(new CenterBox());
    }

    private Shop getShop() {
        return ServiceLocator.getNetworkService().getShop();
    }

    private Dimension getCenterBoxSize() {
        //change this
        return new Dimension(frame.getWidth() * 5 / 6, frame.getHeight() * 5 / 6);
    }

    private Dimension getSidePanelSize() {
        return new Dimension(300, 0);
    }

    private class CenterBox extends JPanel {

        CenterBox() {
            this.setPreferredSize(getCenterBoxSize());
            this.setBackground(color.brighter());
            setup();
        }

        private void setup() {
            this.setLayout(new BorderLayout());
            this.add(new MenuBar(), BorderLayout.NORTH);
            this.add(new MainPanel(), BorderLayout.CENTER);
            this.add(new SidePanel(), BorderLayout.EAST);
            this.add(new Tools(), BorderLayout.SOUTH);
        }

        private static final long serialVersionUID = 1L;
    }

    private class MainPanel extends JScrollPane {

        private final transient Panel panel;

        MainPanel() {
            panel = new Panel() { };
            setup();
            makeTable();
        }

        private void setup() {
            //TODO: add custom scroll bar
            final boolean hasScroll = false;
            if (hasScroll) {
            this.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            this.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            }
            this.setViewportView(panel.getPane());
            panel.getPane().setBackground(this.getBackground());
            this.setSize(getCenterBoxSize()); //hmm..
        }

        private void makeTable() {

            final int offset = 10;
            final CardTable table = new CardTable(
                new Deck("name", getShop().getAllCards()),
                new Dimension(getSize().width - getSidePanelSize().width - offset, getSize().height - offset)
            );
            table.rearrange(3,3);
            final DrawList drawlist = new DrawList().add(table);
            panel.update(drawlist);
        }

        private static final long serialVersionUID = 1L;
    }

    private class SidePanel extends JPanel {
        private static final long serialVersionUID = 1L;

        SidePanel() {
            this.setPreferredSize(getSidePanelSize());
        }

    }

    private class MenuBar extends JPanel {

        private final JButton buyButton;
        private final JButton sellButton;
        private final JButton mainMenuButton;

        MenuBar() {
            buyButton = new JButton("Buy");
            sellButton = new JButton("Sell");
            mainMenuButton = new JButton("Main Menu");
            setup();
        }

        private void setup() {
            this.setBackground(color.darker());
            this.add(mainMenuButton);
            this.add(buyButton);
            this.add(sellButton);
            setActionListeners();
        }

        private void setActionListeners() {
            mainMenuButton.addActionListener( e -> sendEvent(new ChangeMenuEvent(MenuType.MAIN)));
        }

        private static final long serialVersionUID = 1L;
    }

    private class Tools extends JPanel {

        // filter buttons
        private final transient Map<String, ActionListener> filterBtnActions = Map.of("name", e -> {
        }, "mana", e -> {
        }, "hero", e -> {
        });

        private final LinkedHashMap<String, JButton> filterBtnMap;
        private final JTextField textField;
        private final JLabel filterByLabel;

        Tools() {
            filterBtnMap = filterBtnActions.keySet().stream().collect(Collectors.toMap(Function.identity(),
                    key -> makeButton(key, filterBtnActions.get(key)), (e1, e2) -> e1, LinkedHashMap::new));
            textField = filterTextField();
            filterByLabel = filterByLabel();
            setup();
        }

        private JButton makeButton(String text, ActionListener listener) {
            final JButton btn = new JButton();
            btn.setText(text);
            btn.addActionListener(listener);
            return btn;
        }

        private void setup() {
            this.setBackground(color.darker());
            final Box box = Box.createHorizontalBox();
            box.add(textField);
            box.add(Box.createRigidArea(new Dimension(25, 0)));
            box.add(filterByLabel);
            filterBtnMap.values().forEach(box::add);
            this.add(box);
        }

        private JTextField filterTextField() {
            JTextField text = new JTextField();
            final String defaultText = "filter key";
            text.setText(defaultText);
            text.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    text.setText("");
                }

                public void focusLost(FocusEvent e) {
                    if (text.getText().equals(""))
                        text.setText(defaultText);
                }
            });
            final Font font = new Font("Serif", Font.ITALIC, 22);
            text.setFont(font);
            text.setPreferredSize(new Dimension(175, 0));
            return text;
        }

        private JLabel filterByLabel() {
            final JLabel label = new JLabel();
            label.setText("filter by: ");
            label.setForeground(Color.WHITE);
            return label;
        }

        private static final long serialVersionUID = 1L;
    }

    private class CardTable implements Drawable {
        private final List<CardGrid> grids;
        private final Dimension tableDimension;
        private int columns;
        private int rows;

        CardTable(Deck deck, Dimension tableDimension) {
            this.tableDimension = tableDimension;
            grids = generateGrids(deck);
        }
        
        private List<CardGrid> generateGrids(Deck deck) {
            final List<CardGrid> result = new ArrayList<>();
            deck.getCards().forEach(
                card -> result.add(new CardGrid(card)));
            return result;
        }

        public void rearrange(int columns, int rows) {
            arrange(columns, rows);
            resize();
            relocateGrids();
        }

        private void arrange(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
        }

        private void resize() {
            grids.forEach(CardGrid::resize);
        }

        private void relocateGrids() {
            final Iterator<CardGrid> it = grids.iterator();
            for (int j = 0; it.hasNext(); j ++) {
                for (int i=0; i < columns; i ++) {
                    if (! it.hasNext()) break;
                    it.next().relocate(i, j);
                }
            }
        }

        /** don't forget to use rearrange after adding all the cards */
        public void add(CardRecord card) {
            grids.add(new CardGrid(card));
        }

        public void draw(Graphics g) {
            grids.forEach(grid -> grid.draw(g));
        }

        private class CardGrid implements ResizableDrawable {
            private final CardRecord card;

            CardGrid(CardRecord card) {
                this.card = card;
            }

            private void resize() {
                setSize( getGridWidth(), getGridHeight() );
            }

            private void setSize(int w, int h) {
                setSize(
                    new Dimension(w, h)
                );
            }

            public void setSize(Dimension size) {
                card.setSize(size);
            }

            private int getGridHeight() {
                return tableDimension.height / rows;
            }
    
            private int getGridWidth() {
                return tableDimension.width / columns;
            }

            public void relocate(int x, int y) {
                setLocation(x * getGridWidth(), y * getGridHeight());
            }
            
            public void setLocation(int x, int y) {
                card.setLocation(x, y);
            }

            public void draw(Graphics g) {
                card.draw(g);
            }

            //TODO: add mouse listener and effects
        }
    }
}