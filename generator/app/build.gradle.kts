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
}

tasks.jacocoTestReport {
    reports {
        csv.required.set(true)
        xml.required.set(true)
    }
}

tasks.register("generateBat") {
    doFirst {
        // Creates properties file

        val directoryPath = "build/reports/tests/test/classes"

        // Directory of Gradle test reports (NOT Jacoco)
        val reportDirectory = file(directoryPath)

        // Regex already accounts for windows and unix
        val regex = "<tr>(\n|\r\n)<td class=\"(success|failures)\">(.+)</td>".toRegex()

        var resultList = mutableListOf<String>()

        for (className in reportDirectory.list()) {
            val htmlFile = file("$directoryPath/$className").readText()

            val testCaseArray = regex.findAll(htmlFile).map {
                it.groupValues[3]
            }

            for (methodName in testCaseArray) {
                resultList.add(className.split(".")[1] + "." + methodName)
            }
        }

        val batFile = file("testReportGenerator.bat")
        var textToWrite = ""

        for (methodName in resultList) {
            textToWrite += "CALL gradle test --tests $methodName\r\nCALL gradle jacocoTestReport\r\nCALL cd build/reports/jacoco/test\r\nCALL ren html $methodName\r\nCALL cd ../../../../..\r\n"
        }

        batFile.writeText(textToWrite)
    }
}


application {
    // Define the main class for the application.
    mainClass.set("server.Calculator")
}
