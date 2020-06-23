// package com.bubble.hearthstone.controller;

// import java.util.List;

// import com.bubble.hearthstone.card.Card;
// import com.bubble.hearthstone.card.monster.Monster;
// import com.bubble.hearthstone.model.Player;
// import com.bubble.hearthstone.model.arena.Battleground;
// import com.bubble.hearthstone.model.arena.Board;
// import com.bubble.hearthstone.model.arena.Hand;
// import com.bubble.hearthstone.net.event.IGameEvent;
// import com.bubble.hearthstone.net.event.events.arena.SummonEvent;
// import com.bubble.hearthstone.util.services.ServiceLocator;

// public class ArenaMenuController {
    
//     private final Arena arena;

//     public ArenaMenuController(Arena arena) {
//         this.arena = arena;
//         start();
//     }

//     private void start() {
//         final Player player = arena.getPlayer();
//         final Card card = player.getHand().drawCard();
//         sendEvent(
//             new SummonEvent(
//                 card, player.getName()
//             )
//         );
//     }

//     private void sendEvent(IGameEvent event) {
//         ServiceLocator.getNetworkService().push(event);
//     }

//     public Hand getPlayerHand() {
//         return arena.getPlayer().getHand();
//     }
    
//     public List<Monster> getPlayerMonsters() {
//         return arena.getPlayer().getMonsters();
//     }

//     public Battleground getBattleground() {
//         return arena.getBattleground();
//     }
    
//     public Board getBoard() {
//         return getBattleground().getBoard();
//     }
// }