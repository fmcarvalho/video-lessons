package pt.isel

import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotations
import kotlin.reflect.full.memberProperties


fun Any.mapTo(destType: KClass<*>) : Any {
    // 1st - Instantiate destType
    val dest = destType.createInstance()

    // 2nd - Look for properties with same name and type between
    // the receiver and destType
    this::class
        .memberProperties
        .forEach { srcProp ->
            destType
                .memberProperties
                .filter { it is KMutableProperty<*> }
                .map { it as KMutableProperty<*> }
                .firstOrNull { matchProps(srcProp, it) }
                ?.let { destProp: KMutableProperty<*> ->
                    val srcPropValue = srcProp.call(this)
                    destProp.setter.call(dest, srcPropValue)
                }
        }
    return dest
}

fun matchProps(srcProp: KProperty<*>, destProp: KMutableProperty<*>): Boolean {
    return if(destProp.returnType != srcProp.returnType) {
        false
    } else if(destProp.name == srcProp.name) {
        true
    } else {
        srcProp
            .findAnnotations(Match::class)
            .firstOrNull()
            ?.name == destProp.name
    }
}
