package com.bubble.hearthstone.model.card.registry;

import java.util.List;

import com.bubble.hearthstone.model.card.Card;
import com.bubble.hearthstone.model.card.CardRarity;
import com.bubble.hearthstone.model.card.CardType;
import com.bubble.hearthstone.model.card.ability.Ability;
import com.bubble.hearthstone.model.hero.HeroClass;

public class CardBuilder {
    private String name;
    private int manaCost;
    private CardType type;
    private HeroClass heroClass;
    private CardRarity rarity;
    private List<Ability> abilities;
    private String description;

    public CardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CardBuilder setManaCost(int cost) {
        this.manaCost = cost;
        return this;
    }

    public CardBuilder setType(CardType type) {
        this.type = type;
        return this;
    }

    public CardBuilder setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public CardBuilder setRarity(CardRarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public CardBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    public CardBuilder setDescription(String description) {
        this.description = description;
        return this;
    } 

    public Card toCard() {
        return new Card(name, manaCost, type, heroClass, rarity, abilities, description);
    }
}