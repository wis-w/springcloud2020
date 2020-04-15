package demo.cas;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/15 8:33
 */
public class CAS {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println(atomicInteger.incrementAndGet());
    }
}
