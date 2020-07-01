package com.bubble.hearthstone.model.arena;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.bubble.hearthstone.card.monster.Monster;
import com.bubble.hearthstone.stl.Point;

public class Board {

    private final List<Monster> friend;
    private final MonsterGridRow grids;

    Board(List<Monster> friend) {
        this.friend = friend;
        this.grids = new MonsterGridRow(generateGrids(friend));
    }

    private List<MonsterGrid> generateGrids(List<Monster> monsters) {
        return monsters.stream().map(
            monster -> {
                return new MonsterGrid(monster);
            }
            ).collect(Collectors.toList());
    }

    public void insert(int index, Monster monster) {
        grids.insert(index, monster);
    }

    public Monster getLeft(int x) {
        return grids.get(x - 1);
    }
    
    public Monster getRight(int x) {
        return grids.get(x + 1);
    }

    public List<Monster> getAdjacentMonsters(int x) {
        return List.of(getLeft(x), getRight(x));
    }

    MonsterGridRow getGrids() {
        return grids;
    }

    class MonsterGrid {
        private final Monster monster;
        private int x;

        MonsterGrid(Monster monster) {
            this.monster = monster;
        }

        MonsterGrid(Monster monster, int index) {
            this.monster = monster;
            this.x = index;
        }

        void setPosition(int x) {
            this.x = x;
        }

        public int getPosition() {
            return x;
        }

        public void setLocation(Point location) {
            monster.getView().setLocation(location);
        }
    }

    class MonsterGridRow {

        private final LinkedList<MonsterGrid> grids;

        MonsterGridRow(List<MonsterGrid> grids) {
            this.grids = new LinkedList<>(grids);
        }

        Monster get(int index) {
            if (index < 0 || index >= grids.size()) return null;
            return grids.stream()
                .parallel()
                .filter(grid -> (grid.x == index))
                .collect(Collectors.toList())
                .get(0)
                .monster;
        }

        List<Monster> getMonsters() {
            return grids.stream()
                .parallel()
                .map(grid -> grid.monster)
                .collect(Collectors.toList());
        }

        void insert(int index, Monster monster) {
            grids.add(index, new MonsterGrid(monster, index));
        }

        public int size() {
            return grids.size();
        }

        public List<MonsterGrid> getItems() {
            return grids;
        }
    }
}