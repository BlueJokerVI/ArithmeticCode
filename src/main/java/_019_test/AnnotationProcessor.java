package _019_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationProcessor {
   public static void main(String[] args) throws Exception {
       Method method = MyClass.class.getMethod("myMethod");
       if (method.isAnnotationPresent(MyAnnotation.class)) {
           MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
           System.out.println("Annotation value: " + annotation.value());
       }
   }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface MyAnnotation {
        //可以在注解中为属性指定默认值
        String value() default "";
    }

    static class MyClass {
        @MyAnnotation("dad")
        public void myMethod() {}
    }
}