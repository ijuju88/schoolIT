package com.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface AnnotationTest{
	String value() default "-";
	int number() default 15;
}
