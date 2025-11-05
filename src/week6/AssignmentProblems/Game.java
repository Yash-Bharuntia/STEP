package Week6.AssignmentProblems;

import java.util.Objects;

class Game {
    protected String title;

    public Game(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game: " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

class CardGame extends Game {
    private int players;

    public CardGame(String title, int players) {
        super(title);
        this.players = players;
    }

    @Override
    public String toString() {
        return super.toString() + ", Players: " + players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardGame)) return false;
        if (!super.equals(o)) return false;
        CardGame that = (CardGame) o;
        return players == that.players;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), players);
    }
}

public class HWProblem3 {
    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 4);
        CardGame c2 = new CardGame("Poker", 4);
        System.out.println(c1);
        System.out.println(c1.equals(c2));
    }
}
