package sample

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

suspend fun main() {
    println(MyClass().fooTypeParameter<String>().typeName)
}

open class MyClass {
    // Throws NPE onlt when using open AND suspend
    open suspend fun <T> fooTypeParameter() = reifiedType<Foo<T>>()
}

class Foo<T>

open class TypeBase<T>

inline fun <reified T> reifiedType(): Type {
    val base = object : TypeBase<T>() {}
    val superType = base::class.java.genericSuperclass!!
    return (superType as ParameterizedType).actualTypeArguments.first()!!
}
