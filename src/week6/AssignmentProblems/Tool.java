package Week6.AssignmentProblems;

class Tool {
    private String id = "T100";
    protected String name = "Generic Tool";
    public String category = "Hand Tool";

    public String getId() {
        return id;
    }
}

class Hammer extends Tool {
    public void showAccess() {
        System.out.println("ID (private via getter): " + getId());
        System.out.println("Name (protected): " + name);
        System.out.println("Category (public): " + category);
    }
}

public class HWProblem2 {
    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
