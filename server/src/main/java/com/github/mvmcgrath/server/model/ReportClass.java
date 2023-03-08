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
    private Long testCaseId;

    @Column(name = "className", nullable = false)
    private String className;

    @Column(name = "javaCode", nullable = false)
    private String javaCode;

    @Column(name = "htmlReport", nullable = false)
    private String htmlReport;

    @Column(name = "lineNumbers", nullable = false)
    private int[] lineNumbers;
}
