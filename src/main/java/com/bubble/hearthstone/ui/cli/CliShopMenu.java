package com.bubble.hearthstone.ui.cli;

import java.util.List;

import com.bubble.hearthstone.input.EnumCommands;
import com.bubble.hearthstone.input.ICommand;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.MessageEvent;

public class CliShopMenu extends CliMenu {
    private Shop shop;

    public CliShopMenu() {
        this.menuCommands = new CliShopMenuCommnads();
        this.shop = new Shop();
    }

    private final class CliShopMenuCommnads extends MenuCommands {
        CliShopMenuCommnads() {
            super();
            mapper.put("deck", ShopCommands.LIST);
            mapper.put("help", EnumCommands.HELP);
            mapper.put("back", EnumCommands.MAIN_MENU); //to be changed
            mapper.put("out", EnumCommands.LOGOUT);
        }
    }

    private static String printDecks(Shop shop) {
        final StringBuilder builder = new StringBuilder();
        shop.listDecks().forEach(
            deck -> builder.append(
                "\n--------------------------------------------------\n" 
                + deck
            ));
        return builder.toString();
    }

    private enum ShopCommands implements ICommand {
        
        LIST {
            @Override
            public IGameEvent toEvent(String... args) {
                return new MessageEvent(
                    printDecks(new Shop())
                );
            }

            @Override
            public String getDescription() {
                return "list decks";
            }
        },
        BUY {
            @Override
            public IGameEvent toEvent(String... args) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }
        },
    }
}