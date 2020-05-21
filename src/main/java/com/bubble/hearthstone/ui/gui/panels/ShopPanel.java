package com.bubble.hearthstone.ui.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.TableView.TableRow;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.interfaces.ResizableDrawable;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.event.events.ChangeMenuEvent;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.ui.gui.DrawList;
import com.bubble.hearthstone.util.services.ServiceLocator;

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
            panel.getPane().setBackground(this.getBackground());
            this.setHorizontalScrollBar(this.createHorizontalScrollBar());
            this.setViewportView(panel.getPane());
            this.setSize(getCenterBoxSize()); //hmm..
        }

        private void makeTable() {

            final CardTable table = new CardTable(
                new Deck("name", getShop().getAllCards()),
                new Dimension(getSize().width - getSidePanelSize().width, getSize().height)
            );
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

    private class CardTable implements ResizableDrawable {
        private final List<CardRecord> cards;
        private List<CardTableRow> table;
        private Dimension size;
        private final int columns;
        private final int rows;

        CardTable(Deck deck, Dimension size) {
            this.cards = new LinkedList<>(deck.getCards()); //maybe i should change from linkedlist..
            this.table = generateTable(4,2);
            this.size = size;
            this.setSize(size);
            this.setLocation(0, 0);
        }
        
        private List<CardTableRow> generateTable(int c, int r) {
            return arrange(c, r);
        }

        // public void add(CardRecord record) {
        //     cards.add(record);
        // }

        // public void rearrange(int columns) {
        //     rows = arrange(columns);
        // }

        private CardTableItem makeItem() {
            
        }

        private List<CardTableRow> arrange(int columns, int rows) {
            final List<CardTableRow> result = new ArrayList<>();
            final Iterator<CardRecord> it = cards.iterator();
            while(it.hasNext()) {
                result.add(makeRow(columns, it));
            }
            return result;
        }

        private CardTableRow makeRow(int length, Iterator<CardRecord> it) {
            final CardTableRow row = new CardTableRow(length);
            for (int i = 0; i < length && it.hasNext(); i++) {
                row.add(it.next());
            }
            return row;
        }

        public void draw(Graphics g) {
            rows.forEach(row -> row.draw(g));
        }

        private int getItemHeight(Dimension size) {
            return size.height / rows.size();
        }

        @Override
        public void setSize(Dimension size) {
            rows.forEach(
                row -> row.setSize( new Dimension(size.width , getItemHeight(size)) )
                );
            this.size = size;
        }

        @Override
        public void setLocation(int x, int y) {
            final Iterator<CardTableRow> it = rows.iterator();
            for (int i = 0; it.hasNext(); i++) {
                it.next().setLocation(x, y + i * getItemHeight(size));
            }
        }

        private class CardTableRow implements ResizableDrawable {
            private final List<CardTableItem> items;
            private final int maxSize;

            CardTableRow(List<CardRecord> records) {
                this(records.size());
                records.forEach(
                    record -> items.add(new CardTableItem(record))
                );
            }

            CardTableRow(int length) {
                this.items = new ArrayList<>();
                this.maxSize = length;
            }

            public void add(CardRecord record) {
                items.add(
                    new CardTableItem(record)
                );
            }

            @Override
            public void draw(Graphics g) {
                items.forEach(item -> item.draw(g));
            }

            private int getItemWidth(Dimension size) {
                return size.width / maxSize;
            }

            @Override
            public void setSize(Dimension size) {
                items.forEach(
                    item -> item.setSize( new Dimension(getItemWidth(size), size.height) )
                );
            }

            @Override
            public void setLocation(int x, int y) {
                final Iterator<CardTableItem> it = items.iterator();
                for (int i = 0; it.hasNext(); i ++) {
                    it.next().setLocation(x + i * getItemWidth(size), y);
                }
            }
        }

        private class CardTableItem implements ResizableDrawable{
            private final JPanel panel;
            private final CardRecord record;
            private final double drawSizeRatio = 0.95;
            private Dimension size;

            CardTableItem(CardRecord record) {
                this.record = record;
                panel = new JPanel();
                panel.setVisible(false);
                // panel.setBackground(color.brighter()); //change the way it retrieves color maybe
            }

            @Override
            public void draw(Graphics g) {
                record.draw(g);
            }

            @Override
            public void setSize(Dimension size) {
                this.size = size;
                final Dimension drawSize = ratedSize(drawSizeRatio, size);
                panel.setSize(drawSize);
                record.setSize(drawSize);
            }

            private Dimension ratedSize(double ratio, Dimension size) {
                return new Dimension(
                    (int) (size.width * ratio), (int) (size.height * ratio)
                );
            }

            //set sizes before calling this
            @Override
            public void setLocation(int x, int y) {
                final Dimension wastedSpace = ratedSize(1 - drawSizeRatio, size);
                final int drawX = x + wastedSpace.width / 2;
                final int drawY = y + wastedSpace.height / 2;
                panel.setLocation(drawX, drawY);
                record.setLocation(drawX, drawY);
            }
        }
    }
}