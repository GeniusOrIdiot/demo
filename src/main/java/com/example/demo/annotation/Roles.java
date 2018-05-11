package com.example.demo.annotation;

/**
 * @author LiuYJ
 * @since 04/05/2018
 */
class Roles {
    @Comic
    @Animation
    private Role role_1 = new Role("Luffy");

    @Novel(name = "OVERLOAD")
    @Animation(name = "OVERLOAD")
    private Role role_2 = new Role("Anenz");

    @Override
    public String toString() {
        return "Roles{" +
                "role_1=" + role_1 +
                ", role_2=" + role_2 +
                '}';
    }
}
