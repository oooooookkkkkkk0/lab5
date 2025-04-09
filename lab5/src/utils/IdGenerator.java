package utils;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Integer.parseInt;

public class IdGenerator {
    private static final AtomicLong idCounter = new AtomicLong(0);
    //private AtomicIdGenerator() {}

    public static long getNextId() {
        return idCounter.incrementAndGet();
    }

    public static void resetId(long startValue) {
        idCounter.set(startValue);
    }

    public static long getCurrentId() {
        return idCounter.get();
    }
}
