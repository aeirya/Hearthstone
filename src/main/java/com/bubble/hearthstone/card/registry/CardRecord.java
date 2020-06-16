package com.bubble.hearthstone.card.registry;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.bubble.hearthstone.card.Ability;
import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.card.CardView;
import com.bubble.hearthstone.interfaces.Cloneable;
import com.bubble.hearthstone.interfaces.ResizableDrawable;
import com.bubble.hearthstone.model.hero.Hero.HeroClass;
import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.util.serialize.CardSerializer;
import java.util.function.Supplier;
import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

/** an editable version of card, stored in the registry for using */
public class CardRecord extends Card
        implements ResizableDrawable, Cloneable<Card>, Purchasable, InstanceCreator<Purchasable>, Serializable {

    private final transient CardView view;
    // private final transient Map<String, String> fields = Map.of(
    //         "name", getName(),
    //         "description", getDescription()
    //     );

    private final transient Map<String, Supplier<String>> fieldGetter;

    public CardRecord() {
        fieldGetter = Map.of(
            "name", this::getName,
            "description", this::getDescription,
            "mana", this::getManaCost
        );
        view = new CardView("a", this);
        // here is the bug
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
        // GsonSerializer gson = new GsonSerializer(Ability.class,
        //         new AbilityImpl(AbilityType.DRAW, new AbilityArgument()));
        // return gson.serialize(this);
        CardSerializer ser = new CardSerializer();
        return ser.serialize(this, CardRecord.class);
    }

    public String getName() {
        return name;
    }

    public String getManaCost() {
        return String.valueOf(manaCost);
    }

    public String getDescription() {
        return description;
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

    //could've also used a map instead
    //doesn't work, switching to maps
    /** @deprecated */
    @Deprecated
    public String getField(String property) {
        final Field field;
        try {
            field = this.getClass().getDeclaredField(property);
        } catch (NoSuchFieldException | SecurityException e1) {
            return null;
        }
        try {
            return (String) field.get(this);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            return null;
        }
    }

    public String getProperty(String property) {
        // return fields.get(property);
        final Supplier<String> getter = fieldGetter.getOrDefault(property, () -> null);
        if (getter != null) {
            return getter.get();
        }
        else return null;
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