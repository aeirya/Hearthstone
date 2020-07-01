package com.bubble.hearthstone.model.arena;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.model.arena.ArenaPanelConfig.BoardViewConfig;
import com.bubble.hearthstone.model.arena.Board.MonsterGridRow;
import com.bubble.hearthstone.stl.Math;
import com.bubble.hearthstone.stl.Point;

public class BoardView implements Drawable {

    private final MonsterGridRow grids;
    private final BoardViewConfig config;
    private final MonsterGridRowView gridsView;
    private final Point location;

    public BoardView(Board board, BoardViewConfig config) {
        this.config = config;
        this.location = config.getLocation();
        this.grids = board.getGrids();
        this.gridsView = new MonsterGridRowView();
    }

    @Override
    public void draw(Graphics g) {
        gridsView.draw(g);
    }

    private class MonsterGridRowView implements Drawable {

        private List<Integer> getSpacingSequence() {
            final int spacing = config.getSpacingX();
            final int width = config.getMonsterSize().width;
            return Math.getSequence(spacing + width, grids.size());
        }

        private void applySpacing() {
            final List<Integer> locationsX =
                getSpacingSequence()
                .stream()
                .map(x -> x + location.x)
                .collect(Collectors.toList());
            final Integer locationY = location.y;
            grids.getItems().forEach(
                grid -> grid.setLocation(
                    new Point(
                        locationsX.get(grid.getPosition()), 
                        locationY
                    )
                )
            );
        }

        @Override
        public void draw(Graphics g) {
            applySpacing();
            grids.getMonsters().forEach(monster -> monster.draw(g));
        }
    }
}