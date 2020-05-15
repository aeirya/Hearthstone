package com.bubble.hearthstone.ui;

import java.util.EnumMap;
import java.util.Map;

public abstract class MenuLuncher {
    protected final Map<MenuType, Class<? extends IMenu>> mapper;

    MenuLuncher() {
        mapper = new EnumMap<>(MenuType.class);
    }

	protected abstract void lunch(Class<? extends IMenu> menu);
    
    void lunch(MenuType menu) {
        lunch(get(menu));
    }
    
    private Class<? extends IMenu> get(MenuType menuType) {
        return mapper.get(menuType);
    }
}