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

    @Column(name = "htmlReport", length=10000000, nullable = false)
    private String htmlReport;

    public ReportClass() {

    }

    public ReportClass(long reportClassId, long testCaseId, String className, String htmlReport) {
        this.reportClassId = reportClassId;
        this.testCaseId = testCaseId;
        this.className = className;
        this.htmlReport = htmlReport;
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

    public String getHtmlReport() {
        return htmlReport;
    }

    public void setHtmlReport(String htmlReport) {
        this.htmlReport = htmlReport;
    }
}
