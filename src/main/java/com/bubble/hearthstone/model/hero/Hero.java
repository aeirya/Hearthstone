package com.bubble.hearthstone.model.hero;

public class Hero {
    
    private final String name;
    private final HeroHealth hp; 
    private final SpecialPower specialPower;
    private final HeroPower heroPower;
    private HeroWeapon weapon;

    public Hero(String name, int hp, SpecialPower specialPower, HeroPower heroPower, HeroWeapon weapon) {
        this.name = name;
        this.hp = new HeroHealth(hp);
        this.specialPower = specialPower;
        this.heroPower = heroPower;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return hp.getValue();
    }

    public boolean reduceHp(int x) {
        hp.decrease(x);
        return ! hp.isAlive();
    }

    SpecialPower getSpecialPower() {
		return this.specialPower;
	}

    HeroPower getHeroPower() {
		return this.heroPower;
    }
    
    void setWeapon(HeroWeapon weapon) {
        this.weapon = weapon;
    }

    HeroWeapon getWeapon() {
        return weapon;
    }

    public enum HeroClass {
        MAGE, WARLOCK, ROUGE, NEUTRAL
    }
}
