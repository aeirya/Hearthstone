package com.bubble.hearthstone.module.graphics.menu;

import java.util.EnumMap;
import java.util.Map;

public abstract class MenuLauncher implements IMenuLauncher {
    protected final Map<MenuType, Class<? extends IMenu>> mapper;

    MenuLauncher() {
        mapper = new EnumMap<>(MenuType.class);
    }
    
    private Class<? extends IMenu> fetch(MenuType menuType) {
        return mapper.get(menuType);
    }

    public void launch(MenuType menu) {
        launch(fetch(menu));
    }

	protected abstract void launch(Class<? extends IMenu> menu);
}