plugins {
    id("java")
    application
    checkstyle
    jacoco
}
application{mainClass.set("hexlet.code.App")}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc1")
    implementation ("info.picocli:picocli:4.7.6")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()

}
tasks.jacocoTestReport { reports { xml.required.set(true) } }