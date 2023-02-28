package com.github.mvmcgrath.server.core;

import java.io.*;

public class Report {
    final String REPORTS_PATH = "../generator/app/build/reports/jacoco/test";

    final String PACKAGE = "com.github.mvmcgrath.generator.source";

    public File createBashScript(String[] commands) throws Exception {
        File tempScript = File.createTempFile("script", null);

        Writer streamWriter = new OutputStreamWriter(new FileOutputStream(tempScript));
        PrintWriter printWriter = new PrintWriter(streamWriter);

        for (String command : commands) {
            printWriter.println(command);
        }

        printWriter.close();

        return tempScript;
    }

    //Parses HTML page
    public String parseFile(File javaFile) {
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

    public void executeBashScript(String[] commands) {
        File tempScript = null;

        try {
            tempScript = createBashScript(commands);
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
}
