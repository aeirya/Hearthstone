package com.bubble.hearthstone.model.card.registry;

import com.bubble.hearthstone.model.card.Card;
import com.bubble.hearthstone.model.card.CardField;
import com.bubble.hearthstone.model.card.CardRarity;
import com.bubble.hearthstone.model.card.CardType;
import com.bubble.hearthstone.model.card.ability.Ability;
import com.bubble.hearthstone.model.hero.HeroClass;

import java.util.List;
import java.util.Map;

public class CardFactory {

    public Card build(
        String name, int manaCost, CardType type, 
        HeroClass heroClass, CardRarity rarity, 
        List<Ability> abilities, String description){
            return new CardBuilder()
                        .setName(name)
                        .setManaCost(manaCost)
                        .setType(type)
                        .setHeroClass(heroClass)
                        .setRarity(rarity)
                        .setAbilities(abilities)
                        .setDescription(description)
                        .toCard();
    }

    public Card build(Map<CardField, Object> map) {
        return new HashMapCardFactory(map).build();              
    }

    private class HashMapCardFactory {
        private final Map<CardField, Object> map;

        HashMapCardFactory(Map<CardField, Object> map) {
            this.map = map;
        }

        Card build() {
            return new CardBuilder()
                    .setName(
                        get(CardField.NAME, String.class))
                    .setManaCost(
                        get(CardField.MANA, Integer.class))
                    .setType(
                       get(CardField.TYPE, CardType.class))
                    .toCard();
            // test this later (to be completed)
        }

        private <T> T get(CardField field, Class<T> clazz) {
            return clazz.cast(
                map.get(field)
            );
        }
    }
}