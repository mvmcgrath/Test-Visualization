package com.github.mvmcgrath.server.controller;

import com.github.mvmcgrath.server.model.ReportClass;
import com.github.mvmcgrath.server.repository.ReportClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReportClassController {
    @Autowired
    private ReportClassRepository reportClassRepository;

    @GetMapping("/reportClass")
    public List<ReportClass> getAllReports() {
        return reportClassRepository.findAll();
    }
}
