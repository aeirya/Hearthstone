package com.bubble.hearthstone.util.file.serialize;

import com.bubble.hearthstone.card.abilities.ReduceHp;

public class Main {
    public static void main(String[] args) {
        new Main().f();
    }

    void f() {
        ReduceHp t = new ReduceHp();
        
        ISerializer ser = new GsonSerializer();

        System.out.println(ser.serialize(t));


    }
}