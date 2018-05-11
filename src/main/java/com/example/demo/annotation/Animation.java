package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 动漫
 *
 * @author LiuYJ
 * @since 04/05/2018
 */
@Target({
        ElementType.TYPE,
        ElementType.FIELD
})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Animation {
    String name() default "OnePiece";
}
