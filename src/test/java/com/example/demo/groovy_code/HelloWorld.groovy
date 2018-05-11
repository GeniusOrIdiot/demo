package com.example.demo.groovy_code

println(new Person('Alan', 10))

def person = new Person('B', 2)

println(person.name ? firstChar(person.name) : null)

static def firstChar(str) {
    return str.charAt(0)
}

class Person {
    def name
    def age

    Person() {}

    Person(name, age) {
        this.name = name
        this.age = age
    }

    String toString() {
        return "$name, $age"
    }
}