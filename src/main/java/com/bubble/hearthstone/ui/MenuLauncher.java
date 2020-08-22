package com.bubble.hearthstone.ui;

import java.util.EnumMap;
import java.util.Map;

public abstract class MenuLauncher {
    protected final Map<MenuType, Class<? extends IMenu>> mapper;

    MenuLauncher() {
        mapper = new EnumMap<>(MenuType.class);
    }
    
    private Class<? extends IMenu> get(MenuType menuType) {
        return mapper.get(menuType);
    }

    void launch(MenuType menu) {
        launch(get(menu));
    }

	protected abstract void launch(Class<? extends IMenu> menu);
}