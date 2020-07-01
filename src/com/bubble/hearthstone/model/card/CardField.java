package com.bubble.hearthstone.model.card;


public enum CardField {
    NAME,
    MANA,
    TYPE,
    HERO_CLASS,
    RARITY,
    DESCRIPTION;

    /**
     * converts string to card field enum
     */
    public static CardField get(String field) {
        switch (field) {
            case "name":
            return NAME;
            case "mana":
            return MANA;
            case "type":
            return TYPE;
            case "class":
            return HERO_CLASS;
            case "rarity":
            return RARITY;
            case "description":
            return DESCRIPTION;
            default:
            return null;
        }
    }

    @Override
    public String toString() {
        // not implemented
        return super.toString();
    }
}