package com.bubble.hearthstone.model.card;

import java.util.List;

import com.bubble.hearthstone.client.framework.util.serialize.Serializable;
import com.bubble.hearthstone.model.card.ability.Ability;
import com.bubble.hearthstone.model.hero.HeroClass;

public class Card implements Serializable {
    public final String name;
    public final int manaCost;
    public final CardType type;
    public final HeroClass heroClass;
    public final CardRarity rarity;
    public final List<Ability> abilities;
    public final String description;

    public Card(
        String name, int manaCost, CardType type, 
        HeroClass heroClass, CardRarity rarity, 
        List<Ability> abilities, String description) {
            this.name = name;
            this.manaCost = manaCost;
            this.type = type;
            this.heroClass = heroClass;
            this.rarity = rarity;
            this.abilities = abilities;
            this.description = description;
    }
} 