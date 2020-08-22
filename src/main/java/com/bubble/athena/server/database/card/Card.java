package com.bubble.athena.server.database.card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bubble.athena.game.card.CardRarity;
import com.bubble.athena.game.card.CardType;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "cardID")
    private int cardID;

    private String name;

    private int mana;
    private int health;
    private int damage;

    private CardType type;
    private CardRarity rarity;

    public int getCardID() {
        return cardID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardRarity getRarity() {
        return rarity;
    }

    public void setRarity(CardRarity rarity) {
        this.rarity = rarity;
    }
}