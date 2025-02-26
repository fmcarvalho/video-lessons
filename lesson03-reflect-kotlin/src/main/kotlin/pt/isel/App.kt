package pt.isel

import java.net.URL
import java.time.LocalDate
import java.util.Date
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

fun main() {
//    Date::class
//        .members
//        .filter { it.parameters.size == 1 }
//        .forEach { println(it.name) }
    // checkYear(LocalDate.now())
    checkYear(Date())
}

private val fnGetYear = LocalDate::class
    .members
    .first { it.name == "getYear" }

fun checkYear(obj: Any) {
    fnGetYear
        .let { fnGetYear -> fnGetYear.call(obj) }
        .also { println("getYear() => $it") }
}