package com.github.mvmcgrath.server.model;

import javax.persistence.*;

@Entity
@Table(name = "reportclass")
public class ReportClass {
    @Id
    @Column(name="reportClassId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportClassId;

    @ManyToOne(targetEntity = TestCase.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "testCaseId", insertable = false, updatable = false)
    private TestCase testCase;

    @Column(name = "testCaseId")
    private long testCaseId;

    @Column(name = "className", nullable = false)
    private String className;

    @Column(name = "javaCode", nullable = false)
    private String javaCode;

    @Column(name = "htmlReport", nullable = false)
    private String htmlReport;

    @Column(name = "lineNumbers", nullable = false)
    private int[] lineNumbers;

    public ReportClass(long reportClassId, long testCaseId, String className, String javaCode, String htmlReport, int[] lineNumbers) {
        this.reportClassId = reportClassId;
        this.testCaseId = testCaseId;
        this.className = className;
        this.javaCode = javaCode;
        this.htmlReport = htmlReport;
        this.lineNumbers = lineNumbers;
    }

    public long getReportClassId() {
        return reportClassId;
    }

    public void setReportClassId(long reportClassId) {
        this.reportClassId = reportClassId;
    }

    public long getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(long testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    public String getHtmlReport() {
        return htmlReport;
    }

    public void setHtmlReport(String htmlReport) {
        this.htmlReport = htmlReport;
    }

    public int[] getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(int[] lineNumbers) {
        this.lineNumbers = lineNumbers;
    }
}
