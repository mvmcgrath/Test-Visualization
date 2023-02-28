package com.github.mvmcgrath.server.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generator {
    public HashMap<String, ArrayList<Integer>> generateReports() throws Exception {
        new JacocoGen().generateJacocoReports();
        new BTraceGen().generateBTraceReports();
        return new LineGen().generateLineMap();
    }
}
