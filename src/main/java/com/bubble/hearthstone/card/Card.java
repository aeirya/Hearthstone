package com.bubble.hearthstone.card;

import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import com.bubble.hearthstone.util.serialize.Serializable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/** immutable data model for cards */
public class Card implements Serializable {
    protected String name;
    protected int manaCost;
    protected CardType type;
    protected HeroClass heroClass;
    protected CardRarity rarity;
    protected List<Ability> abilities;
    protected String description;

    public enum CardType {
        SPELL, MINION
    }

    public enum CardRarity {
        STARTER, COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }
}

/**
     * name
     * types:
     *      minion, spell, weapon, power, portrait, hero
     * 
     * optinality types:
     *      beast, demon, dragon, elemental, mech, murloc, pirate, totem
     * class
     * cost, attack, health
     * card rarity
     * card text
     * card set
     * isGold
     */ 