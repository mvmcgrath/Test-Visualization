package com.github.mvmcgrath.server.repository;

import com.github.mvmcgrath.server.model.ReportClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportClassRepository extends JpaRepository<ReportClass, Long> {

}
