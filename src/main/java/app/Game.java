package app;

class Game {
    GameManager gameManager;

    Game() {
        initializeComponents();
    }

    private void initializeComponents() {
        gameManager = GameManager.getInstance();
    }

    public static void main(String[] args) {
        //1. Load Game Assets
        //2. Show UI
    }
}