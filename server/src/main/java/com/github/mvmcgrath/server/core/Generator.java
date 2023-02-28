package com.github.mvmcgrath.server.core;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generator {
    final String REPORTS_PATH = "../generator/app/build/reports/jacoco/test";

    final String PACKAGE = "com.github.mvmcgrath.generator.source";

    public HashMap<String, ArrayList<Integer>> generateLineMap() {
        File reportsFolder = new File(REPORTS_PATH);
        File classFolder = new File(reportsFolder.listFiles()[0]  + "/" + PACKAGE);
        return findJavaFiles(classFolder);
    }

    //Finds all java files and collects instruction numbers
    public HashMap<String, ArrayList<Integer>> findJavaFiles(File classFolder) {
        HashMap<String, ArrayList<Integer>> classLinesDict = new HashMap<>();

        for (File javaFile : classFolder.listFiles()) {
            String[] fileSplit = javaFile.getName().split("\\.");

            if (fileSplit[1].equals("java")) {
                String htmlPage = parseHTML(javaFile);
                ArrayList<Integer> lineNumbers = findLineNumbers(htmlPage);
                classLinesDict.put(fileSplit[0], lineNumbers);
            }
        }

        return classLinesDict;
    }

    //Parses HTML page
    public String parseHTML(File javaFile) {
        StringBuilder htmlBuilder = new StringBuilder();

        try {
            BufferedReader input = new BufferedReader(new FileReader(javaFile.getPath()));

            String str = input.readLine();


            while (str != null) {
                htmlBuilder.append(str);
                str = input.readLine();
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return htmlBuilder.toString();
    }

    //Collects line numbers from html page
    public ArrayList<Integer> findLineNumbers(String htmlPage) {
        ArrayList<Integer> lineNumbers = new ArrayList<>();

        String regex = "id=\"L(\\d+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(htmlPage);

        while (matcher.find()) {
            lineNumbers.add(Integer.valueOf(matcher.group(1)));
        }

        return lineNumbers;
    }
    //Generate Jacoco Reports
    public void generateJacocoReports() throws Exception {
        File tempScript = createBashScript();

        try {
            ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            tempScript.delete();
        }
    }

    public File createBashScript() throws Exception {
        File tempScript = File.createTempFile("script", null);

        Writer streamWriter = new OutputStreamWriter(new FileOutputStream(tempScript));
        PrintWriter printWriter = new PrintWriter(streamWriter);

        printWriter.println("#!/bin/bash");
        printWriter.println("cd ../generator");
        printWriter.println("bash ./gradlew generateBat");
        printWriter.println("cd app");
        printWriter.println("bash ./testReportGenerator.sh");

        printWriter.close();

        return tempScript;
    }


}
