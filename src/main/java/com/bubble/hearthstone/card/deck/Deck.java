package com.bubble.hearthstone.card.deck;

import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;
import com.bubble.hearthstone.card.Card.CardRarity;
import com.bubble.hearthstone.card.Card.CardType;
import com.bubble.hearthstone.card.abilities.AbilityDamage;
import com.bubble.hearthstone.card.registry.CardFactory;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import com.bubble.hearthstone.model.shop.Purchasable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Collection<Purchasable> {
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

    public List<String> listCardNames() {
        final List<String> names = new ArrayList<>();
        cards.forEach(card -> names.add(card.getName()));
        return names;
    }

    public void addCard(CardRecord card) {
        cards.add(card);
    }

    public void removeCard(CardRecord card) {
        cards.remove(card);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        listCardNames().forEach(cardname -> builder.append("\n" + cardname));
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String toTable() {
        return Deck.makeTable(this);
    }

    public static String makeTable(Deck deck) {
        final StringBuilder builder = new StringBuilder();
        builder.append("card\t\t\tmana\ttype\tclass\trarity\t\tdescription\n");
        builder.append("--------------------------------------------------\n");
        deck.cards.forEach(card -> builder.append(card.makeRecord() + "\n"));
        return builder.toString();
    }

    public static final CardRecord sampleCard = new CardFactory().build("hi", 1, CardType.MINION, HeroClass.MAGE,
            CardRarity.LEGENDARY, List.of(new AbilityDamage(AbilityType.DRAW, new AbilityArgument())), "HIHSDHDHS");
    private static final CardRecord sampleCard2 = sampleCard.copy().setDescription("this is another card")
            .setHeroClass(HeroClass.ROUGE).setName("Black mage");
    protected static final Deck DEFAULT = new Deck("starter", Arrays.asList(sampleCard, sampleCard2));
    
    //Collection Interface

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return cards.contains(o);
    }

    @Override
    public Iterator<Purchasable> iterator() {
        final List<Purchasable> list = new ArrayList<>();
        cards.forEach(list::add); //types not checked
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return cards.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return cards.toArray(a);
    }

    @Override
    public boolean add(Purchasable e) {
        if (e instanceof CardRecord) return cards.add((CardRecord)e);
        else return false;
    }

    @Override
    public boolean remove(Object o) {
        return cards.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return cards.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Purchasable> c) {
        final Collection<CardRecord> collection = new LinkedList<>();
        c.forEach(card -> collection.add((CardRecord) card)); //supressing warnings
        return cards.addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return cards.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return cards.retainAll(c);
    }

    @Override
    public void clear() {
        cards.clear();
    }
}