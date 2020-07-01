package com.bubble.hearthstone.ui.gui.panels;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.IMenu;
import com.bubble.hearthstone.ui.SwingGraphics;
import com.bubble.hearthstone.ui.gui.DrawList;
import com.bubble.hearthstone.ui.gui.IDrawer;
import com.bubble.hearthstone.ui.gui.components.BackgroundImage;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
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
    private Drawable backgroundImage;

    protected final JFrame frame;

    public Panel(JFrame frame) {
        this.frame = frame;
        if(frame != null)
            this.pane.setPreferredSize(frame.getSize());
    }

    public Panel() {
        this(null);
    }

    public void setBackgroundImage(String imagename) {
        this.backgroundImage = 
            new BackgroundImage(imagename, frame.getSize());
    }

    public JPanel getPane() {
        return pane;
    }

    public void draw(Graphics g) {
        if (backgroundImage != null) backgroundImage.draw(g);
        if (drawList != null) drawList.draw(g);
    }

    public void update(DrawList list) {
        this.drawList = list;
        // stack.update()
        pane.repaint();
    }

    public void launch(IGameGraphics graphics) {
        final SwingGraphics g = (SwingGraphics) graphics;
        g.load(this);
    }
}