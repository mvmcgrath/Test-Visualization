plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    jacoco
    java
    id("com.github.johnrengelman.shadow") version "8.0.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
    implementation("junit:junit:4.13.2")
}

tasks.test {
    testLogging {
        events("passed")
    }
    ignoreFailures = true
    finalizedBy("jacocoTestReport")
}

tasks.register("generateBat") {
    dependsOn("test")
    doLast {
        // Creates properties file

        val directoryPath = "build/reports/tests/test/classes"

        // Directory of Gradle test reports (NOT Jacoco)
        val reportDirectory = file(directoryPath)

        val regex = "<tr>(\n)<td class=\"(success|failures)\">(.+)</td>".toRegex()

        var resultList = mutableListOf<String>()

        for (className in reportDirectory.list()) {
            val htmlFile = file("$directoryPath/$className").readText()

            println("$directoryPath/$className")

            val testCaseArray = regex.findAll(htmlFile).map {
                it.groupValues[3]
            }

            for (methodName in testCaseArray) {
                resultList.add(className.split(".")[5] + "." + methodName)
            }
        }

        val shellFile = file("testReportGenerator.sh")
        var textToWrite = "#!/bin/bash\nrm -r build/reports/jacoco/test\ncd ..\n"

        for (methodName in resultList) {
            textToWrite += "bash ./gradlew :generator:test --tests $methodName\ncd generator/build/reports/jacoco/test\nmv html $methodName\ncd ../../../../..\n"
        }

        shellFile.writeText(textToWrite)
    }
}

//Temporary (hopefully)
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.shadowJar {
    finalizedBy("copyShadowJar")
}

tasks.register<Copy>("copyShadowJar") {
    from(file("build/libs/generator-all.jar"))
    into(file("../btrace/config"))
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs = listOf("-g")
}


application {
    // Define the main class for the application.
    mainClass.set("com.github.mvmcgrath.generator.core.Runner")
}
