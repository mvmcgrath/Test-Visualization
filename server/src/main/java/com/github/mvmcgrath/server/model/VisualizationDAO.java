package com.github.mvmcgrath.server.model;

import javax.persistence.*;

@Entity
@Table(name = "visualizations")
public class VisualizationDAO {
    @Id
    @Column(name="visualizationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long visualizationId;

    @ManyToOne(targetEntity = UserDAO.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private UserDAO user;

    @Column(name = "userId")
    private long userId;

    @Column(name = "title", nullable = false)
    private String title;

    public VisualizationDAO() {

    }

    public VisualizationDAO(long visualizationId, long userId, String title) {
        super();
        this.visualizationId = visualizationId;
        this.userId = userId;
        this.title = title;
    }

    public long getVisualizationId() {
        return visualizationId;
    }

    public void setVisualizationId(long visualizationId) {
        this.visualizationId = visualizationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
