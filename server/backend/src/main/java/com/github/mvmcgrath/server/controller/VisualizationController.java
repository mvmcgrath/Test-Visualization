package com.github.mvmcgrath.server.controller;

import com.github.mvmcgrath.server.exception.ResourceNotFoundException;
import com.github.mvmcgrath.server.model.TestCase;
import com.github.mvmcgrath.server.model.VisualizationDAO;
import com.github.mvmcgrath.server.model.VisualizationDTO;
import com.github.mvmcgrath.server.repository.VisualizationRepository;
import com.github.mvmcgrath.server.service.TestCaseService;
import com.github.mvmcgrath.server.service.VisualizationService;
import com.github.mvmcgrath.server.service.ReportClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class VisualizationController {

    @Autowired
    private VisualizationRepository visualizationRepository;

    @Autowired
    private VisualizationService visualizationService;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private ReportClassService reportClassService;

    @GetMapping("/visuals")
    public List<VisualizationDAO> getAllVisuals() {
        return visualizationRepository.findAll();
    }

    @GetMapping("/visuals/{id}")
    public ResponseEntity<VisualizationDAO> getVisual(@PathVariable long id) {
        VisualizationDAO visual = visualizationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Visualization does not exist with id: " + id));

        return ResponseEntity.ok(visual);
    }

    @PostMapping("/visuals")
    public ResponseEntity<?> createVisualization(@RequestBody VisualizationDTO visualizationDTO) throws Exception {
        VisualizationDAO visual = visualizationService.save(visualizationDTO);
        ArrayList<TestCase> testCases = testCaseService.save(visual);
        reportClassService.save(testCases);

        return ResponseEntity.ok(visual);
    }

    @DeleteMapping("/visuals/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVisualization(@PathVariable Long id) {
        VisualizationDAO image = visualizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visualization does not exist with id: " + id));

        visualizationRepository.delete(image);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
