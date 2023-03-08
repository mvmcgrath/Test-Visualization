package com.github.mvmcgrath.server.model;

import javax.persistence.*;

@Entity
@Table(name = "visualizations")
public class Visualization {
    @Id
    @Column(name="visualizationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long visualizationId;

    @ManyToOne(targetEntity = UserDAO.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private UserDAO user;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "title", nullable = false)
    private String title;
}
