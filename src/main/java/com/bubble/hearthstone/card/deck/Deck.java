package com.bubble.hearthstone.card.deck;

import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;
import com.bubble.hearthstone.card.Card.CardRarity;
import com.bubble.hearthstone.card.Card.CardType;
import com.bubble.hearthstone.card.abilities.AbilityDamage;
import com.bubble.hearthstone.card.registry.CardFactory;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final CardRecord sampleCard = new CardFactory().build("hi", 1, CardType.MINION , HeroClass.MAGE, CardRarity.LEGENDARY, List.of(new AbilityDamage(AbilityType.DRAW, new AbilityArgument())), "HIHSDHDHS") ;
    private List<CardRecord> cards = List.of(sampleCard);
    

    public List<String> listCardNames() {
        final List<String> names = new ArrayList<>();
        cards.forEach(c -> names.add(c.getName()));
        return names;
    }

    public void addCard(CardRecord card) {
        cards.add(card);
    }

    public void removeCard(CardRecord card) {
        cards.remove(card);
    }
}