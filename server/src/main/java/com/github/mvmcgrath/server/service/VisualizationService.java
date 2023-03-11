package com.github.mvmcgrath.server.service;

import com.github.mvmcgrath.server.core.Generator;
import com.github.mvmcgrath.server.model.VisualizationDAO;
import com.github.mvmcgrath.server.model.VisualizationDTO;
import com.github.mvmcgrath.server.repository.VisualizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VisualizationService {
    final String GEN_MAIN_PATH = "../generator/app/src/main/java/com/github/mvmcgrath/generator/";
    final String GEN_TEST_PATH = "../generator/app/src/test/java/com/github/mvmcgrath/generator/source";

    @Autowired
    private VisualizationRepository visualizationRepository;

    private void manageFiles(String[][] sourceFiles, String[][] testFiles) throws Exception{
        final File genSourceDir = new File(GEN_MAIN_PATH + "source");
        final File genTestDir = new File(GEN_MAIN_PATH + "tests");
        final File testDir = new File(GEN_TEST_PATH);

        FileUtils.cleanDirectory(genSourceDir);
        FileUtils.cleanDirectory(genTestDir);
        FileUtils.cleanDirectory(testDir);

        writeFiles(sourceFiles, GEN_MAIN_PATH + "source/", "com.github.mvmcgrath.generator.source");
        writeFiles(testFiles, GEN_MAIN_PATH + "tests/", "com.github.mvmcgrath.generator.tests");
        writeFiles(testFiles, GEN_TEST_PATH + "/", "com.github.mvmcgrath.generator.source");
    }

    private void writeFiles(String[][] files, String outputDir, String newPackage) throws Exception {
        final String replacementPackage = "package " + newPackage + ";\n";
        final String regex = "package [\\w\\.]+;\\n";
        final Pattern pattern = Pattern.compile(regex);

        for (String[] singleFile : files) {
            final Matcher matcher = pattern.matcher(singleFile[1]);

            String fixedFile;

            if (matcher.find()) {
                fixedFile = matcher.replaceFirst(replacementPackage);
            } else {
                fixedFile = replacementPackage + singleFile[1];
            }

            final Writer streamWriter = new OutputStreamWriter(new FileOutputStream(new File(outputDir + singleFile[0])));
            final PrintWriter printWriter = new PrintWriter(streamWriter);
            printWriter.write(fixedFile);
            printWriter.close();
        }
    }

    public VisualizationDAO save(VisualizationDTO visual) throws Exception {
        VisualizationDAO newVisual = new VisualizationDAO();
        newVisual.setUserId(visual.getUserId());
        newVisual.setTitle(visual.getTitle());

        manageFiles(visual.getSourceFiles(), visual.getTestFiles());

        HashMap<String, ArrayList<Integer>> lineMap = new Generator().generateReports();





        return visualizationRepository.save(newVisual);
    }
}
