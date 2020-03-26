package app;

public abstract class Game {

    GameManager gameManager;

    Game() {
        initializeComponents();
    }

    private void initializeComponents() {
        gameManager = GameManager.getInstance();
    }
}