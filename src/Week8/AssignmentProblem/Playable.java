package Week8.AssignmentProblem;


interface Playable {
    void play();
    void pause();
}

class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("MusicPlayer: Playing music...");
    }

    @Override
    public void pause() {
        System.out.println("MusicPlayer: Music paused.");
    }
}

class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("VideoPlayer: Playing video...");
    }

    @Override
    public void pause() {
        System.out.println("VideoPlayer: Video paused.");
    }
}

public class PlayerTest {
    public static void main(String[] args) {
        Playable ref;

        ref = new MusicPlayer();
        ref.play();
        ref.pause();

        System.out.println();

        ref = new VideoPlayer();
        ref.play();
        ref.pause();
    }
}
