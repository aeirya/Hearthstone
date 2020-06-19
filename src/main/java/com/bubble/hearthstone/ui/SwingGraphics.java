package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.input.IGameInput;
import com.bubble.hearthstone.ui.gui.components.Frame;
import com.bubble.hearthstone.ui.gui.panels.ArenaPanel;
import com.bubble.hearthstone.ui.gui.panels.DecksPanel;
import com.bubble.hearthstone.ui.gui.panels.LoginPanel;
import com.bubble.hearthstone.ui.gui.panels.MainMenuPanel;
import com.bubble.hearthstone.ui.gui.panels.Panel;
import com.bubble.hearthstone.ui.gui.panels.SettingsPanel;
import com.bubble.hearthstone.ui.gui.panels.ShopPanel;

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
    private final MenuLauncher launcher;
    private Panel currentPanel;

    public SwingGraphics() {
        frame = initiateFrame();
        launcher = new SwingLauncher();
    }
    
    // TODO : replace jframe with frame later
    protected JFrame initiateFrame() {
        final JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        f.setSize(getWindowSize());
        f.setBackground(Color.BLACK);
        f.setVisible(true);
        return f;
    }

    static Dimension getWindowSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height);
    }

    public void load(Panel panel) {
        this.currentPanel = panel;
        frame.setContentPane(panel.getPane());
        frame.pack();
    }

    public void update() {
        if (currentPanel != null)
            currentPanel.update(
                null
            ); //pass drawables here
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
        //
    }
    /////////////

    @Override
    public void launch(MenuType menu) {
        launcher.launch(menu);
    }

    private final class SwingLauncher extends MenuLauncher {

        SwingLauncher() {
            super();
            init();
        }

        private void init() {
            mapper.put(MenuType.LOGIN, LoginPanel.class);
            mapper.put(MenuType.MAIN, MainMenuPanel.class);
            mapper.put(MenuType.DECKS, DecksPanel.class);
            mapper.put(MenuType.SHOP, ShopPanel.class);
            mapper.put(MenuType.SETTINGS, SettingsPanel.class);
            mapper.put(MenuType.ARENA, ArenaPanel.class);
        }

        private void run(IMenu menu) {
            menu.launch(SwingGraphics.this);
        }

        @Override
        protected void launch(Class<? extends IMenu> clazz) {
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
        //
    }

    @Override
    public IMenu getCurrentMenu() {
        return currentPanel;
    }

    @Override
    public void bind(IGameInput input) {
        //reminder: swap with the Frame
        input.bind(
            new Frame(frame)
        );
    }
}