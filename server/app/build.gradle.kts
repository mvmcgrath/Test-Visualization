plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    jacoco
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    testImplementation("junit:junit:4.13.2")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
}

tasks.test {
    testLogging {
        events("passed")
    }
    ignoreFailures = true
    doLast {
        // Creates properties file

        val directoryPath = "build/reports/tests/test/classes"

        // Directory of Gradle test reports (NOT Jacoco)
        val reportDirectory = file(directoryPath)

        // Regex already accounts for windows and unix
        val regex = "<tr>(\n|\r\n)<td class=\"(success|failures)\">(.+)</td>".toRegex()

        for (className in reportDirectory.list()) {
            val htmlFile = file("$directoryPath/$className").readText()

            val testCaseArray = regex.findAll(htmlFile).map {
                it.groupValues[3]
            }

            for (caseName in testCaseArray) {
                println(caseName)
            }
        }
    }
}


application {
    // Define the main class for the application.
    mainClass.set("server.Calculator")
}
