package org.sse.examples.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation1
{
    int value1();
    int value2();
    String str() default "[unassigned]";
}
