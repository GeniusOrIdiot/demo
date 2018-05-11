package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author LiuYJ
 * @since 04/05/2018
 */
@Target({
        ElementType.TYPE,
        ElementType.FIELD
})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Comic {
    String name() default "OnePiece";
}
