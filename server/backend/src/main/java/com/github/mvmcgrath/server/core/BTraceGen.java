package com.github.mvmcgrath.server.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class BTraceGen extends Report {

    final String RUNNER_PATH = "../generator/src/main/java/com/github/mvmcgrath/generator/core/Runner.java";

    public void generateBTraceReports() {
        HashMap<String, ArrayList<String>> classMap = findTestCases();

        String[] commands = new String[]{"#!/bin/bash", "cd ../btrace/config", "rm -r results", "mkdir results"};
        executeBashScript(commands);

        for (String className : classMap.keySet()) {
            classMap.get(className).forEach(testName -> generateSingleReport(className, testName));
        }
    }

    public HashMap<String, ArrayList<String>> findTestCases() {
        HashMap<String, ArrayList<String>> classMap = new HashMap<>();

        File reportsFolder = new File(REPORTS_PATH);

        for (File testCaseFolder : Objects.requireNonNull(reportsFolder.listFiles())) {
            String[] testName = testCaseFolder.getName().split("\\.");

            if (classMap.containsKey(testName[0])) {
                classMap.get(testName[0]).add(testName[1]);
            } else {
                classMap.put(testName[0], new ArrayList<>(Collections.singletonList(testName[1])));
            }
        }

        return classMap;
    }

    public void generateSingleReport(String className, String testName) {
        configureRunner(className, testName);

        String[] commands = new String[]{"#!/bin/bash", "cd ..", "bash ./gradlew :generator:shadowJar",
                "cd btrace/config", "java -javaagent:../libs/btrace-agent.jar=scriptOutputFile=" + className + "." + testName +
                ".txt,script=BTraceConfig.class -jar generator-all.jar", "mv " + className + "." + testName + ".txt results"};
        executeBashScript(commands);
    }

    public void configureRunner(String className, String testName) {
        File file = new File(RUNNER_PATH);

        String parsedFile = parseFile(new File(RUNNER_PATH));


        String originalRegex = "tests\\.\\w+\"\\), \"\\w+\"";
        String replacement = "tests." + className + "\"), \"" + testName + "\"";

        parsedFile = parsedFile.replaceFirst(originalRegex, replacement);

        try {
            Writer streamWriter = new OutputStreamWriter(new FileOutputStream(file));
            PrintWriter printWriter = new PrintWriter(streamWriter);
            printWriter.write(parsedFile);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}
