package sample

import kotlinx.coroutines.runBlocking
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

fun main(): Unit = runBlocking {
    println(MyClass().fooTypeParameter<String>().typeName)
}

@MyAnnotation  // No error without this annotation
class MyClass {

    // No error without suspend
    suspend fun <T> fooTypeParameter() = reifiedType<Foo<T>>()
}

class Foo<T>

open class TypeBase<T>

inline fun <reified T> reifiedType(): Type {
    val base = object : TypeBase<T>() {}
    val superType = base::class.java.genericSuperclass!!
    return (superType as ParameterizedType).actualTypeArguments.first()!!
}

annotation class MyAnnotation()
