import kotlin.reflect.full.*

fun main() {
    val propName = Person::class
        .memberProperties
        .first { it.name.contains("name")}
    propName
        .call(Person("Ze Manel", "Portugal"))
        .also { println(it) }
    propName
        .call(Artist("pop rock", "David Bowie", Country("UK", "english")))
        .also { println(it) }
}

fun listMembers() {
        println("################################ Class Person members: ")
    Person::class
        .members
        .forEach { println(it) }

    println("################################ Class Person declared members: ")
    Person::class
        .declaredMembers
        .forEach { println(it) }

    println("################################ Class Person functions: ")
    Person::class
        .memberFunctions
        .forEach { println(it) }
    
    println("################################ Class Account members: ")
    Account::class
        .members
        .forEach { println(it) }
    
    println("################################ Class Rectangle members: ")
    Rectangle::class
        .members
        .forEach { println(it) }
}

