package com.github.mvmcgrath.server.controller;

import com.github.mvmcgrath.server.exception.ResourceNotFoundException;
import com.github.mvmcgrath.server.model.TestCase;
import com.github.mvmcgrath.server.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TestCaseController {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @GetMapping("/testCases")
    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    @GetMapping("/testCases/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A test case does not exist with id: " + id));

        return ResponseEntity.ok(testCase);
    }
}
