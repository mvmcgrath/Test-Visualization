package com.github.mvmcgrath.server.model;

import javax.persistence.*;

@Entity
@Table(name = "testcase")
public class TestCase {
    @Id
    @Column(name="testCaseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testCaseId;

    @ManyToOne(targetEntity = Visualization.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "visualizationId", insertable = false, updatable = false)
    private Visualization visualization;

    @Column(name = "visualizationId")
    private Long visualizationId;

    @Column(name = "methodName", nullable = false)
    private String methodName;

    @Column(name = "executionOrder", nullable = false)
    private String[] exectionOrder;
}
