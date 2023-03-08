package com.github.mvmcgrath.server.repository;

import com.github.mvmcgrath.server.model.Visualization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualizationRepository extends JpaRepository<Visualization, Long> {

}
