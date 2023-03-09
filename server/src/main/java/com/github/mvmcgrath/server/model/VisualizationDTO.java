package com.github.mvmcgrath.server.model;

public class VisualizationDTO {
    private String[] sourceFiles;

    private String[] testFiles;

    private int userId;

    private String title;

    public String[] getSourceFiles() {
        return sourceFiles;
    }

    public void setSourceFiles(String[] sourceFiles) {
        this.sourceFiles = sourceFiles;
    }

    public String[] getTestFiles() {
        return testFiles;
    }

    public void setTestFiles(String[] testFiles) {
        this.testFiles = testFiles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
