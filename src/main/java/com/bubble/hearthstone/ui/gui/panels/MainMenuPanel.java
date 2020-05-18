package com.bubble.hearthstone.ui.gui.panels;

import com.bubble.hearthstone.controller.MainMenuManager;
import com.bubble.hearthstone.interfaces.IInterpreter;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
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

    public MainMenuPanel(final JFrame frame) {
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
    }

    private Box buttonsBox() {
        Box box = Box.createVerticalBox();
        btnTexts.forEach(str -> box.add(makeButton(str)));
        return box;
    }

    private JButton makeButton(String text) {
        JButton btn = new JButton();
        btn.setText(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 20));
        btn.addActionListener((ActionEvent e) -> mapper.interpret(e.getActionCommand()));
        return btn;
    }

    private class CenterPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        private CenterPanel(JFrame frame) {
            setup(frame);
        }

        private void setup(JFrame frame) {
            this.setPreferredSize(new Dimension(300, 600));
            this.setBackground(pane.getBackground());
            this.setLayout(new GridBagLayout());
            this.setPreferredSize(frame.getSize());
            this.add(buttonsBox());
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