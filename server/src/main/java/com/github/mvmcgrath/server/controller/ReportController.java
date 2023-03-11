package com.github.mvmcgrath.server.controller;

import com.github.mvmcgrath.server.core.Generator;
import com.github.mvmcgrath.server.model.VisualizationDTO;
import com.github.mvmcgrath.server.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ReportController {

    @Autowired
    private VisualizationService visualizationService;

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

    @PostMapping("/reports")
    public ResponseEntity<?> createVisualization(@RequestBody VisualizationDTO visualizationDTO) throws Exception {
        return ResponseEntity.ok(visualizationService.save(visualizationDTO));
    }
}
