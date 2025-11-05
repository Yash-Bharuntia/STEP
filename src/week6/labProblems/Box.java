package Week6.LabProblems;

public class Box {
    public void pack() {
        System.out.println("Box is packed.");
    }

    public void unpack() {
        System.out.println("Box is unpacked.");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Gift wrapping added with ribbons.");
    }

    @Override
    public void unpack() {
        super.unpack();
        System.out.println("Unwrapping the gift packaging.");
    }
}

public class LabProblem6 {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}
