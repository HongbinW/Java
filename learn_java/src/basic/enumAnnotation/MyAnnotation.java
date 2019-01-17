package basic.enumAnnotation;
//自定义注解
public @interface MyAnnotation {
    String value() default "hello";
}
