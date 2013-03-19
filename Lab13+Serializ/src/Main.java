import java.util.*;

class X {
    public void f() {
        g();
    }
    
   static void g() {
        System.out.println("Gigi");
    }
}

class A extends X {

    static void g() {
        System.out.println("Ion");
    }
    
}


public class Main {
    public static void main(String[] params) {
        A a = new A();
        a.f(); // Gigi
    }
}