package com.github.mvmcgrath.server.service;

import com.github.mvmcgrath.server.core.Generator;
import com.github.mvmcgrath.server.core.Report;
import com.github.mvmcgrath.server.model.TestCase;
import com.github.mvmcgrath.server.model.VisualizationDAO;
import com.github.mvmcgrath.server.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TestCaseService {
    final String JACOCO_REPORT_PATH = "../generator/app/build/reports/jacoco/test";

    final String BTRACE_REPORT_PATH = "../generator/btrace/config/results/";

    @Autowired
    private TestCaseRepository testCaseRepository;

    public ArrayList<TestCase> save(VisualizationDAO visual) throws Exception {
        final HashMap<String, ArrayList<Integer>> lineMap = new Generator().generateReports();
        final ArrayList<TestCase> testCases = new ArrayList<>();

        final File jacocoReportDir = new File(JACOCO_REPORT_PATH);

        final String regex = "([\\w\\.]+ \\d+)\n";
        final Pattern pattern = Pattern.compile(regex);

        for (File testCase : jacocoReportDir.listFiles()) {
            ArrayList<String> executionOrder = new ArrayList<>();

            final String fileName = testCase.getName();

            final File btraceReport = new File(BTRACE_REPORT_PATH + fileName + ".txt");

            final String parsedReport = new Report().parseFile(btraceReport);

            Matcher matcher = pattern.matcher(parsedReport);

            while (matcher.find()) {
                executionOrder.add(matcher.group(1));
            }

            final TestCase newTestCase = new TestCase();
            newTestCase.setMethodName(fileName);
            newTestCase.setExecutionOrder(executionOrder.toArray(new String[0]));
            newTestCase.setVisualizationId(visual.getVisualizationId());
            testCases.add(testCaseRepository.save(newTestCase));
        }

        return testCases;
    }
}
