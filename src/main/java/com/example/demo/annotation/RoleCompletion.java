package com.example.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author LiuYJ
 * @since 04/05/2018
 */
public class RoleCompletion {
    public static void main(String[] args) throws IllegalAccessException {
        Roles roles = new Roles();
        Field[] fields = roles.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            StringBuilder sb = new StringBuilder("");
            for (Annotation annotation : annotations) {
                if (annotation instanceof Animation) {
                    Animation animation = (Animation) annotation;
                    sb.append("[").append(Animation.class.getSimpleName()).append(":").append(animation.name()).append("]");
                }
                if (annotation instanceof Comic) {
                    Comic comic = (Comic) annotation;
                    sb.append("[").append(Comic.class.getSimpleName()).append(":").append(comic.name()).append("]");
                }
                if (annotation instanceof Novel) {
                    Novel novel = (Novel) annotation;
                    sb.append("[").append(Novel.class.getSimpleName()).append(":").append(novel.name()).append("]");
                }
            }
            Class clazz = field.getType();
            if (clazz.equals(Role.class)) {
                try {
                    field.setAccessible(true);
                    Method method = Role.class.getMethod("setWork", String.class);
                    method.setAccessible(true);
                    method.invoke(field.get(roles), sb.toString());
                } catch (NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(roles);
    }
}
