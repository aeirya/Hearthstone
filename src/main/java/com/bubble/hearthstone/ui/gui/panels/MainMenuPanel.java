package com.bubble.hearthstone.ui.gui.panels;

import com.bubble.hearthstone.controller.MainMenuManager;
import com.bubble.hearthstone.interfaces.IInterpreter;
import com.bubble.hearthstone.util.services.ServiceLocator;

import java.awt.Image;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusListener;
import java.util.List;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainMenuPanel extends Panel {

    private final IInterpreter mapper;
    private final JTextField commandTextBox;
    private JPanel centerPanel;
    private final boolean hasBackgroundImage = true;

    public MainMenuPanel(final JFrame frame) {
        super(frame);
        mapper = new MainMenuManager();
        commandTextBox = new CommandTextbox();
        setup(frame);
    }

    private void setup(JFrame frame) {
        pane.setBackground(Color.DARK_GRAY);
        pane.setLayout(new BorderLayout());
        centerPanel = new CenterPanel(frame);
        pane.add(commandTextBox, BorderLayout.NORTH);
        pane.add(centerPanel, BorderLayout.CENTER);
        setBackgroundImage("dragon_landscape");
    }

    private Box buttonsBox() {
        Box box = Box.createVerticalBox();
        btnTexts.forEach(str -> box.add(makeButton(str)));
        return box;
    }

    private JButton makeButton(String text) {
        JButton btn = new JButton();
        btn.setText(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 36)); //was set to 2
        btn.addActionListener((ActionEvent e) -> mapper.interpret(e.getActionCommand()));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        return btn;
    }

    private class CenterPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private CenterPanel(JFrame frame) {
            setup(frame);
        }

        private void setup(JFrame frame) {
            this.setPreferredSize(new Dimension(300, 600));
            this.setBackground(new Color(0,0,0,0));
            this.setLayout(new GridBagLayout());
            this.setPreferredSize(frame.getSize());
            this.add(buttonsBox());
        }

        private Image getBackgroundImage() {
            return ServiceLocator.getResources().getImage("dragon_landscape");
        }

        private void drawBackgroundImage(Graphics g) {
            g.drawImage(getBackgroundImage(), 0, 0, null);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // if (hasBackgroundImage) drawBackgroundImage(g);
            
        }
    }

    private List<String> btnTexts = List.of("Start", "See Decks", "Profile", "Settings", "Logout", "Quit");

    private class CommandTextbox extends JTextField {

        private static final long serialVersionUID = 1L;
        private final String defaultText = "what do you wish to do master?";

        private CommandTextbox() {
            addFocusListener(new CommandTextBoxFocusListener());
            setText(defaultText);
            setFont(
                new Font("SansSerif", Font.BOLD, 20)
            );
        }

        private class CommandTextBoxFocusListener implements FocusListener {

            public void focusGained(FocusEvent e) {
                setText("");
            }

            public void focusLost(FocusEvent e) {
                setText(defaultText);
            }
        }
    }
}