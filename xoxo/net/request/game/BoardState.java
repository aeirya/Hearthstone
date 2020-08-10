package xoxo.net.request.game;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import xoxo.game.Block;

public class BoardState {
    private final List<Block> blocks;
    private final int N;

    public BoardState(List<Block> filledBlocks, int N) {
        this.N = N;
        this.blocks = indexBlocks();
        fill(filledBlocks);
    }

    private void fill(List<Block> filledBlocks) {
        filledBlocks.forEach(
            block -> find(block.x, block.y).fill(block.getSign())
        );
    }

    private List<Block> indexBlocks() {
        final List<Block> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list.add(new Block(i, j));
            }
        }
        return list;
    }

    private Block find(int x, int y) {
        return blocks.get(N * x + y);
    }
    
    public List<Block> getBlocks() {
        return blocks;
    }

    public int getSize() {
        return N;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}