package com.github.mvmcgrath.server.controllers;

import com.github.mvmcgrath.server.core.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/")
public class ReportController {

    @GetMapping("/reports")
    public String getAllReports() {
        Generator gen = new Generator();
        HashMap<String, ArrayList<Integer>> map = gen.generateLineMap();
        return "Hello world!";
    }
}
