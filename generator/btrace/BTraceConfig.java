package com.github.mvmcgrath.generator.core;

import org.openjdk.btrace.core.annotations.*;
import static org.openjdk.btrace.core.BTraceUtils.*;

@BTrace public class BTraceConfig {
    @OnMethod(
        clazz="/com\\.github\\.mvmcgrath\\.generator\\.core\\.Runner\\..*/",
        method="/.*/"
    )

    public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod) {
        println(probeClass);
        println(probeMethod);
    }
}
