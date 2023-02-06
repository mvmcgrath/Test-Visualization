package com.github.mvmcgrath.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ReportController {

    @GetMapping("/reports")
    public String getAllReports() {
        return "Hello world!";
    }
}
