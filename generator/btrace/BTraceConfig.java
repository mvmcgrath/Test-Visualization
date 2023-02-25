import org.openjdk.btrace.core.annotations.*;
import static org.openjdk.btrace.core.BTraceUtils.*;

@BTrace public class BTraceConfig {

    @OnMethod(
            clazz="/com\\.github\\.mvmcgrath\\.generator\\.source\\..*/",
            method="/.*/",
            location=@Location(value = Kind.LINE,
                line = -1
            )
    )
    public static void calcLine3(@ProbeClassName String probeClass, int line) {
        println(probeClass + " " + line);
    }
}
