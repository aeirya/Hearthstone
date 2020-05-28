package com.bubble.hearthstone.model.arena;

import java.awt.Dimension;
import java.awt.Color;

public class ArenaPanelConfig {
    
    //graphics
    public Dimension getHandPanelSize(Dimension screenSize) {
        return new Dimension(
            screenSize.width, screenSize.height * 2 / 10
            );
    }

    private int getHandOffsetY(Dimension handPanelSize, Dimension cardSize) {
        return (-1) * handPanelSize.height * 5 /10;
    }

    private int getHandSpawnY(Dimension screenSize, Dimension cardSize) {
        final Dimension handPanelSize = getHandPanelSize(screenSize);
        return screenSize.height - cardSize.height + getHandOffsetY(handPanelSize, cardSize);
    }

    public int getHandSpawnY(Dimension screenSize, int handSize) {
        return getHandSpawnY(screenSize, getCardSize(screenSize, handSize));
    }

    public int getSelectedCardSpawnY(Dimension screenSize, int handSize) {
        return getHandSpawnY(screenSize, getSelectedCardSize(getCardSize(screenSize, handSize)));
    }

    public Dimension getCardSize(Dimension screenSize, int handSize) {
        final int maxCardShownInHand = 12;
        final int width = getHandCardWidth(screenSize, maxCardShownInHand, handSize);
        return new Dimension(
            width , getHandCardHeight(width)
        );
    }

    public Dimension getSelectedCardSize(Dimension cardSize) {
        final double zoomRatio = 1.3;
        return new Dimension((int) (cardSize.width * zoomRatio), (int) (cardSize.height * zoomRatio) );
    }

    private int getHandCardHeight(int handCardWidth) {
        return handCardWidth * 4 / 3;
    }

    private int getHandCardWidth(Dimension screensize, int maxCardShownInHand, int handSize) {
        final int n = Math.min(maxCardShownInHand, Math.max(handSize, 5));
        return screensize.width * 4 / 5 / n;
    }

    public Color getArenaBackgroundColor() {
        return new Color(70, 60, 50);
    }

	public Color getHandPanelColor() {
		return getArenaBackgroundColor().darker();
	}
}