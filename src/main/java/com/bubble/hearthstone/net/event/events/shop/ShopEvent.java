// package com.bubble.hearthstone.net.event.events.shop;

// import com.bubble.hearthstone.model.shop.Shop;
// import com.bubble.hearthstone.model.shop.Wallet;
// import com.bubble.hearthstone.net.user.User;
// import com.bubble.hearthstone.net.user.UserInventory;
// import com.bubble.hearthstone.net.user.UserSave;
// import com.bubble.hearthstone.util.resource.ResourceManager;
// import com.bubble.hearthstone.util.services.ServiceLocator;
// import java.util.function.Consumer;

// public abstract class ShopEvent implements IShopEvent {

//     protected Consumer<GameManager> consumer;
//     private UserSave userSave;

//     @Override
//     public void process(GameManager manager) {
//         consumer.accept(manager);
//     }

//     protected Shop getShop() {
//         return ServiceLocator.getNetworkService().getShop();
//     }

//     private UserSave getUserSave(User user) {
//         if (userSave == null) {
//             final ResourceManager res =  ServiceLocator.getResources();
//             userSave = res.loadSave(user);
//         }
//         return userSave;
//     }

//     protected Wallet getWallet(User user) {
//         return getUserSave(user).getWallet();
//     }

//     protected UserInventory getUserCollection(User user) {
//         return getUserSave(user).getCollection();
//     }
// }