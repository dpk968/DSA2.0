import java.util.concurrent.atomic.AtomicLong;


public class IdGenerator {
private static AtomicLong counter = new AtomicLong(5000);
public static String next(String prefix) {
return prefix + counter.getAndIncrement();
}
}