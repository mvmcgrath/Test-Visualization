package com.github.mvmcgrath.server.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Generator {
    public HashMap<String, ArrayList<Integer>> generateReports() throws Exception {
        new JacocoGen().generateJacocoReports();
        new BTraceGen().generateBTraceReports();
        return new LineGen().generateLineMap();
    }
}
