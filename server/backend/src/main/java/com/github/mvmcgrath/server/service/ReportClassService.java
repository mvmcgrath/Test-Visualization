package com.github.mvmcgrath.server.service;

import com.github.mvmcgrath.server.core.Report;
import com.github.mvmcgrath.server.model.ReportClass;
import com.github.mvmcgrath.server.repository.ReportClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.mvmcgrath.server.model.TestCase;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReportClassService {
    final String JACOCO_REPORT_PATH = "../generator/build/reports/jacoco/test/";

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

                    final String regex = "<div class=\"breadcrumb\" .*?</div>";
                    final Pattern firstPattern = Pattern.compile(regex);
                    final Matcher firstMatcher = firstPattern.matcher(parsedReport);
                    final String fixedReport = firstMatcher.replaceAll("");
                    final Pattern secondPattern = Pattern.compile("linenums\">package com\\.github\\.mvmcgrath\\.generator\\.source;");
                    final Matcher secondMatcher = secondPattern.matcher(fixedReport);
                    final String finalFixedReport = secondMatcher.replaceAll("linenums\">");

                    newReportClass.setHtmlReport(finalFixedReport);
                    reportClassRepository.save(newReportClass);
                }
            }
        }
    }
}
