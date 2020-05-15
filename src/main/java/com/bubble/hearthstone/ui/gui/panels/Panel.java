package com.bubble.hearthstone.ui.gui.panels;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.IMenu;
import com.bubble.hearthstone.ui.SwingGraphics;
import com.bubble.hearthstone.ui.gui.DrawList;
import com.bubble.hearthstone.ui.gui.IDrawer;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public abstract class Panel implements Drawable, IDrawer, IMenu {

    protected final JPanel pane = new JPanel(new GridBagLayout()) {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }
    };
    
    private DrawList drawList;

    public JPanel getPane() {
        return pane;
    }

    public void draw(Graphics g) {
        if (drawList != null) drawList.draw(g);
    }

    public void update(DrawList list) {
        this.drawList = list;
        pane.repaint();
    }

    public void lunch(IGameGraphics graphics) {
        final SwingGraphics g = (SwingGraphics) graphics;
        g.load(this);
    }
}