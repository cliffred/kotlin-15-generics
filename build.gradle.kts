plugins {
//    id("org.jetbrains.kotlin.jvm") version "1.4.32" // No error with Kotlin 1.4
    id("org.jetbrains.kotlin.jvm") version "1.5.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
}

allOpen {
    annotation("sample.MyAnnotation") // No error without allOpen
}
