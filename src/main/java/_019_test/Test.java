package _019_test;

import java.util.HashMap;

/**
 * @author cct
 */
public class Test {
    public interface A {
        default void f() {
            return;
        }

        ;
    }

    public interface B {
        default void f() {
            return;
        }

        ;
    }

    public class C implements A, B {

        @Override
        public void f() {
            A.super.f();
        }
    }


    public void f(int a) {
    }

    public int f(String a) {
        return 1;
    }
}
