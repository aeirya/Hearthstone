// package com.bubble.hearthstone.ui.gui.panels;

// import java.awt.Dimension;
// import javax.swing.JFrame;
// import java.awt.Graphics;

// import com.bubble.hearthstone.controller.Arena;
// import com.bubble.hearthstone.controller.ArenaMenuController;
// import com.bubble.hearthstone.interfaces.Drawable;
// import com.bubble.hearthstone.model.arena.ArenaPanelConfig;
// import com.bubble.hearthstone.model.arena.BoardView;
// import com.bubble.hearthstone.model.arena.HandView;
// import com.bubble.hearthstone.ui.gui.DrawList;
// import com.bubble.hearthstone.ui.gui.components.Frame;
// import com.bubble.hearthstone.util.services.ServiceLocator;

// public class ArenaPanel extends Panel {
    
//     private final ArenaMenuController arena;
//     private final ArenaPanelConfig config;
//     private final HandPanel handPanel;
//     private final HandView handView;
//     private final BoardView boardView;

//     // what if i pass every panel its controller (here Arena) by the graphcis.lunch(clazz, controller)
//     public ArenaPanel(JFrame frame) {
//         super(frame);
//         arena = new ArenaMenuController(getArena());
//         config = new ArenaPanelConfig(new Frame(frame));
//         handPanel = new HandPanel();
//         handView = new HandView(
//             arena.getPlayerHand(), config, frame.getSize());
//         boardView = new BoardView(arena.getBoard(), config.getBoardViewConfig());
//         setup();
//     }

//     private void setup() {
//         pane.setBackground(
//             config.getArenaBackgroundColor()
//         );
//         this.update(
//             new DrawList()
//                 .add(handPanel)
//                 .add(handView)
//                 .add(boardView)
//         );
//     }

//     private Arena getArena() {
//         return ServiceLocator.getNetworkService().getArena();
//     }

//     private class HandPanel implements Drawable {

//         public void draw(Graphics g) {
//             final Dimension handPanelSize = config.getHandPanelSize(frame.getSize());
//             g.setColor(config.getHandPanelColor());
//             g.fillRect(0, frame.getSize().height - handPanelSize.height, frame.getSize().width, handPanelSize.height);
//         }      
//     }
// }