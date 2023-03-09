package com.github.mvmcgrath.server.model;

import javax.persistence.*;

@Entity
@Table(name = "testcase")
public class TestCase {
    @Id
    @Column(name="testCaseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testCaseId;

    @ManyToOne(targetEntity = VisualizationDAO.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "visualizationId", insertable = false, updatable = false)
    private VisualizationDAO visualizationDAO;

    @Column(name = "visualizationId")
    private long visualizationId;

    @Column(name = "methodName", nullable = false)
    private String methodName;

    @Column(name = "executionOrder", nullable = false)
    private String[] executionOrder;

    public TestCase() {

    }

    public TestCase(long testCaseId, Long visualizationId, String methodName, String[] executionOrder) {
        super();
        this.testCaseId = testCaseId;
        this.visualizationId = visualizationId;
        this.methodName = methodName;
        this.executionOrder = executionOrder;
    }

    public long getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(long testCaseId) {
        this.testCaseId = testCaseId;
    }

    public long getVisualizationId() {
        return visualizationId;
    }

    public void setVisualizationId(Long visualizationId) {
        this.visualizationId = visualizationId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(String[] executionOrder) {
        this.executionOrder = executionOrder;
    }
}
