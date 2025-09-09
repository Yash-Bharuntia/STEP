package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public AccessModifierDemo(int pf, String df, double prf, boolean pubf) {
        privateField = pf;
        defaultField = df;
        protectedField = prf;
        publicField = pubf;
    }

    public void testInternalAccess() {
        System.out.println("Private Field: " + privateField);
        System.out.println("Default Field: " + defaultField);
        System.out.println("Protected Field: " + protectedField);
        System.out.println("Public Field: " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "Hello", 20.5, true);
        System.out.println(demo.publicField);
        demo.publicMethod();
        demo.testInternalAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo(5, "World", 15.5, false);
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}
