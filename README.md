# Sample project to reproduce bug in Kotlin 1.5 with reified generics and all-open plugin

When calling a suspending generic function from a class annotated with an annotation that is processed by the all-open plugin it's impossible to get the actualTypeArguments of the reified generic.

Running the main function in Sample.kt results in a NullPointerException. But only in this exact setup. Making any of the following changes will make it run successfully with the output `sample.Foo<T>`:
 
 - Downgrade Kotlin to 1.4
 - Remove @MyAnnotation from MyClass or remove it from allOpen{}
 - Make fooTypeParameter() not suspending


