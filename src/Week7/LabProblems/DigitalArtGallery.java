package Week7.LabProblems;

public class DigitalArtGallery {

    // Parent and child classes
    static class Artwork {
        String title;
        public Artwork(String title) { this.title = title; }
    }
    static class Painting extends Artwork {
        public Painting(String title) { super(title); }
        public void inspectBrushwork() {
            System.out.println("Inspecting the impressionistic brushwork of '" + title + "'.");
        }
    }
    static class Sculpture extends Artwork {
        public Sculpture(String title) { super(title); }
        public void checkMaterial() {
            System.out.println("Checking the marble material of '" + title + "'.");
        }
    }

    public static void main(String[] args) {
        Artwork[] gallery = {
                new Painting("Starry Night"),
                new Sculpture("David")
        };

        Artwork artPiece = gallery[0];

        // At this point, artPiece is of type Artwork.
        // The compiler does NOT know it is a Painting.
        // artPiece.inspectBrushwork(); // COMPILE ERROR!

        // To access Painting-specific methods, we must downcast.
        if (artPiece instanceof Painting) {
            System.out.println("Curator: 'This piece is a painting. Let's look closer.'");
            Painting specificPainting = (Painting) artPiece; // Explicit downcast
            specificPainting.inspectBrushwork();
        }
    }
}
