package pt.isel

import java.net.URL
import java.util.Date
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

fun main() {
    Date::class.java
        .declaredFields
        .forEach { println(it.name + ": " + it.type.kotlin.simpleName) }
}

