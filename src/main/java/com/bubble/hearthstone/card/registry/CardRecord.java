package com.bubble.hearthstone.card.registry;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import com.bubble.hearthstone.card.Ability;
import com.bubble.hearthstone.card.AbilityImpl;
import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.card.CardView;
import com.bubble.hearthstone.card.Ability.AbilityArgument;
import com.bubble.hearthstone.card.Ability.AbilityType;
import com.bubble.hearthstone.interfaces.Cloneable;
import com.bubble.hearthstone.interfaces.ResizableDrawable;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.util.serialize.GsonSerializer;
import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

/** an editable version of card, stored in the registry for using */
public class CardRecord extends Card
        implements ResizableDrawable, Cloneable<Card>, Purchasable, InstanceCreator<Purchasable>, Serializable {

    private final transient CardView view;

    public CardRecord() {
        view = new CardView("a");
        // here is the bug3
    }

    @SerializedName("type")
    private static final String ITEM_TYPE = "card";

    public CardRecord copy() {
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
        GsonSerializer gson = new GsonSerializer(Ability.class,
                new AbilityImpl(AbilityType.DRAW, new AbilityArgument()));
        return gson.serialize(this);
    }

    public String getName() {
        return name;
    }

    public String makeRecord() {
        return name + "\t\t\t" + manaCost + "\t" + type + "\t" + heroClass + "\t" + rarity + "\t\t" + description;
    }

    public String[] getRecord() {
        return new String[] { name, String.valueOf(manaCost), String.valueOf(type), String.valueOf(heroClass),
                String.valueOf(rarity), description };
    }

    public static String[] getRecordTitle() {
        return new String[] { "card", "mana", "type", "class", "rarity", "description" };
    }

    // gonna add pricing later
    public int getPrice() {
        return 1;
    }

    @Override
    public Purchasable createInstance(Type type) {
        return new CardRecord();
        // return this.copy();
    }

    @Override
    public void draw(Graphics g) {
        view.draw(g);
    }
    
    @Override
    public void setSize(Dimension size) {
       view.setSize(size);
    }

    @Override
    public void setLocation(int x, int y) {
        view.setLocation(x, y);
    }

    private static final long serialVersionUID = 1L;
}