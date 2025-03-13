package pt.isel

import java.lang.reflect.Method
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.isAccessible

fun Appendable.log(target: Any, indentation: Int = 0) {
    appendLine(target::class.simpleName)
    target::class
        .java
        .declaredMethods
        .filter { it.parameters.isEmpty() && it.returnType != Unit::class.java}
        .forEach { method ->
            indent(indentation)
            append("- ${method.name}: ")
            propValue(target, method, indentation)
        }
}

fun Appendable.indent(indentation: Int) {
    repeat(indentation) { append(" ")}
}

fun Appendable.propValue(target: Any, method: Method, indentation: Int) {
    method.isAccessible = true
    val propValue = method.invoke(target)
    if(propValue == null) {
        appendLine("null")
    }
    else if(isPrimitive(propValue)) {
        appendLine(propValue.toString())
    } else {
        log(propValue, indentation + 2)
    }
}

fun isPrimitive(propValue: Any): Boolean {
    return propValue is Int
    || propValue is Long
    || propValue is Float
    || propValue is Double
    || propValue is Short
    || propValue is Byte
    || propValue is Boolean
    || propValue is String
}
