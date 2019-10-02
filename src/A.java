import java.util.Arrays;

public class A {
    private static int count = 0;

    /**
     * Increments count in a thread-safe​​​​​​‌​​​‌​​‌​​‌​​‌​​​​​‌​​‌‌​ manner.
     */
    public static synchronized int increment() {
        count = count + 1;
        return count;
    }


}

