package com.bubble.hearthstone.ui.gui.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class BackgroundImage implements Drawable {

    private final Dimension frameSize;
    private final Image image;

    public BackgroundImage(String imagename, Dimension frameSize) {
        this.frameSize = frameSize;
        this.image = ServiceLocator.getResources().getImage(imagename);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, frameSize.width, frameSize.height, null);
    }
}