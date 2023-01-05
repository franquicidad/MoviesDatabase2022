package com.example.moviesdatabase.kotlinPractice

fun main() {
    val dog = Dog()

    dog.apply {
        val printBark = this.bark()
        println(printBark)
    }

    with(dog) {
        this.bark()
        this.moves()
    }

}

abstract class Animal {
    fun moves(): String {
        return "The animal moves"
    }
}

interface Bark {
    fun bark(): String
}

interface swim {
    fun swim(): String {
        return "The animal swims"
    }
}

interface fly {
    fun fly(): String {
        return "The animal flyes."
    }
}

class Dog() : Animal(), Bark {
    override fun bark(): String {
        return "wof wof"
    }

}