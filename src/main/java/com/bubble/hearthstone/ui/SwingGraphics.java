package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.ui.gui.panels.LoginPanel;
import com.bubble.hearthstone.ui.gui.panels.MainMenuPanel;
import com.bubble.hearthstone.ui.gui.panels.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGraphics implements IGameGraphics {

    protected final JFrame frame;
    private Panel currentPanel;
    private MenuLuncher luncher;

    public SwingGraphics() {
        frame = initiateFrame();
        luncher = new SwingLuncher();
    }

    /**
     * this is a test for
     * lunching  main menu / login menu
     */
    public static void main(String[] args) {
        final boolean B = false;
        final IGameGraphics graphics = new SwingGraphics();
        if (B) graphics.lunch(MenuType.LOGIN);
        else graphics.lunch(MenuType.MAIN);
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
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 3,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2);
    }

    public void load(Panel panel) {
        this.currentPanel = panel;
        frame.setContentPane(panel.getPane());
        frame.pack();
    }

    public void update() {
        currentPanel.update(null); // TODO: pass drawables here
        repaint();
    }

    private void repaint() {
        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void message(String message) {
        JOptionPane.showMessageDialog(frame, message, "logger", JOptionPane.INFORMATION_MESSAGE);
    }

    ///////////

    public Object receive() {
        return null;
    }

    @Override
    public void error(String message) {
        // TODO Auto-generated method stub

    }
    /////////////

    @Override
    public void lunch(MenuType menu) {
        luncher.lunch(menu);
    }

    private final class SwingLuncher extends MenuLuncher {

        SwingLuncher() {
            super();
            init();
        }

        private void init() {
            mapper.put(MenuType.LOGIN, LoginPanel.class);
            mapper.put(MenuType.MAIN, MainMenuPanel.class);
        }

        private void run(IMenu menu) {
            menu.lunch(SwingGraphics.this);
        }

        @Override
        protected void lunch(Class<? extends IMenu> clazz) {
            final IMenu menu = make(clazz);
            if (menu != null) run(menu);
        }

        private IMenu make(Class<? extends IMenu> clazz) {
            final Constructor<? extends IMenu> c = getConstructor(clazz);
            if (c != null) return construct(c);
            else return null;
        }

        private Constructor<? extends IMenu> getConstructor(Class<? extends IMenu> clazz) {
            try {
                return clazz.getConstructor(JFrame.class);
            } catch (NoSuchMethodException | SecurityException e) {
                //
            }
            return null;
        }

        private IMenu construct(Constructor<? extends IMenu> c) {
            try {
                return c.newInstance(frame);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                //
            }
            return null;
        }
    }

    @Override
    public void showHelp() {
        // TODO Auto-generated method stub

    }
}