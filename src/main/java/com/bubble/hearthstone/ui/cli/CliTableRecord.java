package com.bubble.hearthstone.ui.cli;

import java.lang.reflect.Field;

public abstract class CliTableRecord<T> {
    private final T item;

    public CliTableRecord(T item) {
        this.item = item;
    }

    public abstract String makeRecord();

    public void setField(String fieldname, Object value) {
        Field field;
        try {
            field = item.getClass().getField(fieldname);
            field.set(item, value);
        } catch (NoSuchFieldException | SecurityException 
                | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}