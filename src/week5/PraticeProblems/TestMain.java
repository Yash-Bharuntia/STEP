package Week5.PraticeProblems;
package com.company.main;
import com.company.security.AccessModifierDemo;
public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(1, "A", 2.5, true);
        System.out.println(obj.publicField);
        obj.publicMethod();
    }
}
File: com/company/extended/ExtendedDemo.java
package com.company.extended;
import com.company.security.AccessModifierDemo;
public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int p, String d, double pr, boolean pub) {
        super(p, d, pr, pub);
    }
    public void testInheritedAccess() {
        System.out.println(protectedField);
        System.out.println(publicField);
        protectedMethod();
        publicMethod();
    }
    public static void main(String[] args) {
        ExtendedDemo child = new ExtendedDemo(1, "X", 5.5, true);
        child.testInheritedAccess();
    }
}
