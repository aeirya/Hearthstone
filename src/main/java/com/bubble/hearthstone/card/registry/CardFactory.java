package com.bubble.hearthstone.card.registry;

import com.bubble.hearthstone.card.Ability;
import com.bubble.hearthstone.card.Card.CardRarity;
import com.bubble.hearthstone.card.Card.CardType;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import java.util.List;

public class CardFactory {

    public CardRecord build(
        String name, int manaCost, CardType type, 
        HeroClass heroClass, CardRarity rarity, 
        List<Ability> abilities, String description){
            return new CardRecord()
                        .setName(name)
                        .setManaCost(manaCost)
                        .setType(type)
                        .setHeroClass(heroClass)
                        .setRarity(rarity)
                        .setAbilities(abilities)
                        .setDescription(description);
    }
}