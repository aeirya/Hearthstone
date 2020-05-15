package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.ui.gui.panels.LoginPanel;
import com.bubble.hearthstone.ui.gui.panels.MainMenuPanel;
import com.bubble.hearthstone.ui.gui.panels.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGraphics implements IGameGraphics {

    protected final JFrame frame;
    private Panel currentPanel;

    public SwingGraphics() {
        frame = initiateFrame();
        // load(new LoginPanel(frame));
        load(new MainMenuPanel(frame)); 
    }

    protected JFrame initiateFrame() {
        final JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        f.setSize(getWindowSize());
        f.setBackground(Color.BLACK);
        f.setVisible(true);
        return f;
    }

    static Dimension getWindowSize() {
        return new Dimension(
            Toolkit.getDefaultToolkit().getScreenSize().width/3 ,
            Toolkit.getDefaultToolkit().getScreenSize().height/2
        );
    }

    public void load(Panel panel) {
        this.currentPanel = panel;
        frame.setContentPane(panel.getPane());
        frame.pack();
    }

    public void update() {
        currentPanel.update(null); //TODO: pass drawables here
        repaint();
    }

    public Object receive() {
        return null;
    }

    private void repaint() {
        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void message(String message) {
        JOptionPane.showMessageDialog(
            frame, message, "logger", JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void error(String message) {
        // TODO Auto-generated method stub

    }
}