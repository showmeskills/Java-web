package demo03.customAnnotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    MyAnnotation[] value() default {};
}
