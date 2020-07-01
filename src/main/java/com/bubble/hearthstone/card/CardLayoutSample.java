package com.bubble.hearthstone.card;

import com.bubble.hearthstone.card.registry.CardRecord;
import java.awt.Point;
import java.awt.Font;
import java.util.Map;

public class CardLayoutSample extends CardLayout {


    public CardLayoutSample(String name, CardRecord record) {
        super(
            name, 
            record, 
            new CardLayoutConfig(
                Map.of(
                    "name", new Point(5,5),
                    "description", new Point(5, 7),
                    "mana", new Point(1,1),
                    "type", new Point(1,9)
                ),  
                Map.of(
                    "default" , new Font(Font.SANS_SERIF, Font.BOLD, 30),
                    "name" , new Font(Font.SANS_SERIF, Font.BOLD, 30),
                    "description" , new Font(Font.SANS_SERIF, Font.PLAIN, 20),
                    "mana", new Font(Font.SANS_SERIF, Font.BOLD, 40)
                )
            )
        );
    }
    
}