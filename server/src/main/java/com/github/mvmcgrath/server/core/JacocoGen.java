package com.github.mvmcgrath.server.core;

import java.io.File;

public class JacocoGen extends Report {
    //Generate Jacoco Reports
    public void generateJacocoReports() throws Exception {
        String[] commands = new String[]{"#!/bin/bash", "cd ../generator", "bash ./gradlew generateBat", "cd app", "bash ./testReportGenerator.sh"};
        executeBashScript(commands);
    }
}
