import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        Map<Integer, Long> mems = new HashMap<>();
        long orMask = 0L;
        long andMask = 0L;
        while (in.hasNext()) {
            String op = in.next();
            if (op.equals("mask")) {
                String mask = in.next();
                orMask = Long.parseLong(mask.replaceAll("X", "0"), 2);
                andMask = Long.parseLong(mask.replaceAll("X", "1"), 2);
            } else { // mem
                int addr = in.nextInt();
                long value = in.nextLong() & andMask | orMask;
                mems.put(addr, value);
            }
        }
        long ans = 0;
        for (Long value: mems.values()) ans += value;
        System.out.println(ans);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in)).useDelimiter("(\\s|\\[|\\]|=)+");;
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
