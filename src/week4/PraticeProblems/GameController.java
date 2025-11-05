package Week4.PraticeProblems;

class GameController {
    private String gameName;
    private int difficultyLevel;

    public GameController() {
        gameName = "Default Game";
        difficultyLevel = 1;
    }

    public GameController(String gameName, int difficultyLevel) {
        this.gameName = gameName;
        this.difficultyLevel = difficultyLevel;
    }

    public GameController(String gameName) {
        this(gameName, 1);
    }

    public void display() {
        System.out.println("Game: " + gameName + " | Difficulty: " + difficultyLevel);
    }
}

public class Q2Main {
    public static void main(String[] args) {
        GameController g1 = new GameController();
        GameController g2 = new GameController("Chess", 5);
        GameController g3 = new GameController("Ludo");
        g1.display();
        g2.display();
        g3.display();
    }
}
