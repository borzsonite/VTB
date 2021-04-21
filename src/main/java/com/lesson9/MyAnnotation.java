package com.lesson9;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Аннотацию можно использовать в runtime
@Target(ElementType.METHOD) // В качестве таргета - метод.
public @interface MyAnnotation {

}
