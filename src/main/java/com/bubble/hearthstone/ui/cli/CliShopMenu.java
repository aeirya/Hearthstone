package com.bubble.hearthstone.ui.cli;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.input.EnumCommands;
import com.bubble.hearthstone.input.ICommand;
import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.MessageEvent;
import com.bubble.hearthstone.net.event.events.shop.BuyEvent;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class CliShopMenu extends CliMenu {

    public CliShopMenu() {
        this.menuCommands = new CliShopMenuCommnads();
    }
    
    
    private final class CliShopMenuCommnads extends MenuCommands {
        CliShopMenuCommnads() {
            super();
            mapper.put("deck", ShopCommands.LIST);
            mapper.put("buy", ShopCommands.BUY);
            mapper.put("sell", ShopCommands.SELL);
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
                    printDecks(getShop())
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
                if (args.length > 0)
                    return new BuyEvent(
                        getPurchasable(args[0]) , getMe()
                        );
                else return null;
            }

            @Override
            public String getDescription() {
                return "buy [cardname]";
            }
        },
        SELL {
            @Override
            public IGameEvent toEvent(String... args) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getDescription() {
                return "sell [cardname]";
            }
        };

        private static User getMe() {
            return ServiceLocator.getNetworkService().getMe();
        }

        private static Shop getShop() {
            return ServiceLocator.getNetworkService().getShop();
        }

        private static Purchasable getPurchasable(String name) {
            return (CardRecord) getShop().getCardRegistry().get(name);
        }

        //move the codes to events
        //decadle an id for each card to manage buys and sells
    }
}