package com.bubble.hearthstone.stl;

import java.util.ArrayList;
import java.util.List;

public class Math {
    
    private Math() { }

    public static List<Integer> getSequence(int d, int size) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(i * d);
        }
        return result;
    }
}