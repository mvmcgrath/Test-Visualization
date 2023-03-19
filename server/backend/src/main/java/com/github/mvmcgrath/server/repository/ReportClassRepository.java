package com.github.mvmcgrath.server.repository;

import com.github.mvmcgrath.server.core.Report;
import com.github.mvmcgrath.server.model.ReportClass;
import com.github.mvmcgrath.server.model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportClassRepository extends JpaRepository<ReportClass, Long> {
    @Query("SELECT r FROM ReportClass r WHERE r.testCaseId =:testCaseId")
    List<ReportClass> findByTestCaseId(@Param("testCaseId") long testCaseId);
}
