package com.github.mvmcgrath.server.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineGen extends Report {
    public HashMap<String, ArrayList<Integer>> generateLineMap() {
        File reportsFolder = new File(REPORTS_PATH);
        File classFolder = new File(Objects.requireNonNull(reportsFolder.listFiles())[0]  + "/" + PACKAGE);
        return findJavaFiles(classFolder);
    }

    //Finds all java files and collects instruction numbers
    public HashMap<String, ArrayList<Integer>> findJavaFiles(File classFolder) {
        HashMap<String, ArrayList<Integer>> classLinesDict = new HashMap<>();

        for (File javaFile : Objects.requireNonNull(classFolder.listFiles())) {
            String[] fileSplit = javaFile.getName().split("\\.");

            if (fileSplit[1].equals("java")) {
                String htmlPage = parseFile(javaFile);
                ArrayList<Integer> lineNumbers = findLineNumbers(htmlPage);
                classLinesDict.put(fileSplit[0], lineNumbers);
            }
        }

        return classLinesDict;
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
}
