package com.github.mvmcgrath.server.controller;

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
        HashMap<String, ArrayList<Integer>> lineMap = null;

        try {
            lineMap = new Generator().generateReports();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : lineMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        return "Hello world!";
    }
}
