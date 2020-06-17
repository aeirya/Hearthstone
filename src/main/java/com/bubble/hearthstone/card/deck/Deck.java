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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Deck {
    private final String name; // will be implement a naming system later
    private final Collection<CardRecord> cards;

    public Deck(String name, Collection<CardRecord> cards) {
        this.cards = cards;
        this.name = name;
    }

    public Deck(String name) {
        cards = new ArrayList<>();
        DEFAULT.cards.forEach(card -> cards.add(card.copy()));
        this.name = name;
    }

    public void addCard(CardRecord card) {
        cards.add(card);
    }

    public void removeCard(CardRecord card) {
        cards.remove(card);
    }

    public Collection<CardRecord> getCards() {
        return this.cards;
    }

    public String getName() {
        return name;
    }

    public static final CardRecord sampleCard = new CardFactory().build("hi", 1, CardType.MINION, HeroClass.MAGE,
            CardRarity.LEGENDARY, List.of(new AbilityDamage(AbilityType.DRAW, new AbilityArgument())), "HIHSDHDHS");
    private static final CardRecord sampleCard2 = sampleCard.copy().setDescription("this is another card")
            .setHeroClass(HeroClass.ROUGE).setName("Black mage");
    protected static final Deck DEFAULT = new Deck("starter", Arrays.asList(sampleCard, sampleCard2));
    
    //Collection Interface

}