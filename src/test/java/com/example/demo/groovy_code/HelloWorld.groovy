package com.example.demo.groovy_code

println(new Person('Alan', 10))

def person = new Person('B', 2)

println(person.name ? firstChar(person.name) : null)

def calendar = Calendar.getInstance()
calendar.set(Calendar.DAY_OF_MONTH, 1)
println(new Date(calendar.getTimeInMillis()))
println(calendar.get(Calendar.MONTH))

static def firstChar(str) {
    return str.charAt(0)
}

new Boy().introduce()

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

    def introduce() {
        println 'Im a person'
    }
}

class Boy extends Person {

    def introduce() {
        println 'Im a boy'
        super.introduce()
    }
}