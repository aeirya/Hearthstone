package com.bubble.hearthstone.card.registry;

import java.util.List;

import com.bubble.hearthstone.card.Ability;
import com.bubble.hearthstone.card.AbilityImpl;
import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;
import com.bubble.hearthstone.interfaces.Cloneable;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import com.bubble.hearthstone.util.serialize.GsonSerializer;

/** an editable version of card, stored in the registry for using */
public class CardRecord extends Card implements Cloneable <Card> {

    public Card copy() {
        return new CardFactory().build(name, manaCost, type, heroClass, rarity, abilities, description);                      
    }

    public CardRecord setName(String name) {
        this.name = name; 
        return this;
    }

    public CardRecord setManaCost(int cost) {
        this.manaCost = cost;
        return this;
    }

    public CardRecord setType(CardType type) {
        this.type = type;
        return this;
    }

    public CardRecord setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public CardRecord setRarity(CardRarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public CardRecord setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    public CardRecord setDescription(String description) {
        this.description = description;
        return this;
    }

    public String toString() {
        GsonSerializer gson = new GsonSerializer(Ability.class, new AbilityImpl(AbilityType.DRAW, new AbilityArgument()));
        return gson.serialize(this);
    }

    public String getName() {
        return name;
    }

    public String makeRecord() {
        return 
            name + "\t" + 
            manaCost + "\t" + 
            type + "\t" + 
            heroClass + "\t" + 
            rarity + "\t" + 
            description;
    }
}