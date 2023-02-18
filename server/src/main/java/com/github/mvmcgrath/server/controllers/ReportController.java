package com.github.mvmcgrath.server.controllers;

import com.github.mvmcgrath.server.core.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ReportController {

    @GetMapping("/reports")
    public String getAllReports() {
        Generator generator = new Generator();
        generator.generateJacocoReports();
        HashMap<String, ArrayList<Integer>> map = generator.generateLineMap();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        return "Hello world!";
    }
}
