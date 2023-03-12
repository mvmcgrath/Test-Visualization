package com.github.mvmcgrath.server.service;

import com.github.mvmcgrath.server.core.Report;
import com.github.mvmcgrath.server.model.ReportClass;
import com.github.mvmcgrath.server.repository.ReportClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.mvmcgrath.server.model.TestCase;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class ReportClassService {
    final String JACOCO_REPORT_PATH = "../generator/app/build/reports/jacoco/test/";

    @Autowired
    private ReportClassRepository reportClassRepository;

    public void save(ArrayList<TestCase> testCases) {
        for (TestCase testcase : testCases.toArray(new TestCase[0])) {
            final File testCaseDir = new File(JACOCO_REPORT_PATH + testcase.getMethodName() + "/com.github.mvmcgrath.generator.source");

            for (File reportFile : testCaseDir.listFiles()) {
                final String[] fileName = reportFile.getName().split("\\.");

                if (fileName[1].equals("java")) {
                    final ReportClass newReportClass = new ReportClass();
                    newReportClass.setTestCaseId(testcase.getTestCaseId());
                    newReportClass.setClassName(fileName[0]);

                    final String parsedReport = new Report().parseFile(reportFile);
                    newReportClass.setHtmlReport(parsedReport);
                    reportClassRepository.save(newReportClass);
                }
            }
        }
    }
}
