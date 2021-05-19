# Sample project to reproduce bug in Kotlin 1.5 with reified generics

When calling an open suspending generic function it's impossible to get the actualTypeArguments of the reified generic.

Running the main function in Sample.kt results in a NullPointerException. But only in this exact setup. Making any of the following changes will make it run successfully with the output `sample.Foo<T>`:
 
 - Downgrade Kotlin to 1.4
 - Make fooTypeParameter() not suspending
 - Make fooTypeParameter() final

See https://youtrack.jetbrains.com/issue/KT-46797
