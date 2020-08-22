package com.bubble.hearthstone.ui.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bubble.hearthstone.net2.event.events.ChangeMenuEvent;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class DecksPanel extends Panel {

    public DecksPanel(JFrame frame) {
        super(frame);
        pane.setBackground(Color.YELLOW.darker());
        pane.add(new CenterBox());
    }

    private class CenterBox extends JPanel {

        private final JButton shopButton;

        CenterBox() {
            shopButton = new JButton("Go to Shop");
            setup();
        }

        private void setup() {
            this.setPreferredSize(
                new Dimension(frame.getWidth() * 3 / 4, frame.getHeight() * 9 / 10)
            );
            this.setBackground(pane.getBackground().brighter());
            this.setLayout(new BorderLayout());
            this.initializeComponents();
        }
        
        private void initializeComponents() {
            this.add(shopButton);
            shopButton.addActionListener(
                e -> ServiceLocator.getNetworkService().push(
                    new ChangeMenuEvent(MenuType.SHOP)
                )
            );
        }

        private static final long serialVersionUID = 1L;
    }
}