package com.bubble.hearthstone.ui.gui.panels;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Graphics;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.model.arena.ArenaPanelConfig;
import com.bubble.hearthstone.ui.gui.DrawList;

public class ArenaPanel extends Panel {
    
    private final ArenaPanelConfig config;
    private final HandPanel handPanel;

    public ArenaPanel(JFrame frame) {
        super(frame);
        handPanel = new HandPanel();
        config = new ArenaPanelConfig();
        setup();
    }

    private void setup() {
        pane.setBackground(
            config.getArenaBackgroundColor()
        );
        final CardRecord card = new CardRecord();
        card.setLocation(
            100, config.getHandSpawnY(frame.getSize(), 3));
        card.setSize(
            config.getCardSize(frame.getSize(), 3));
        this.update(
            new DrawList().add(handPanel).add(card)
        );
    }

    private class HandPanel implements Drawable {

        public void draw(Graphics g) {
            final Dimension handPanelSize = config.getHandPanelSize(frame.getSize());
            g.setColor(config.getHandPanelColor());
            g.fillRect(0, frame.getSize().height - handPanelSize.height, frame.getSize().width, handPanelSize.height);
        }      
    }
}