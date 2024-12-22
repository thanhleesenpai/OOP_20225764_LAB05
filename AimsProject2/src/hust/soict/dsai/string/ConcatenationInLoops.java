package hust.soict.dsai.string;
import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Using String with "+" operator
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("String: " + (System.currentTimeMillis() - start) + " ms");

        // Using StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - start) + " ms");

        // Using StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbf.append(r.nextInt(2));
        }
        System.out.println("StringBuffer: " + (System.currentTimeMillis() - start) + " ms");
    }
}
