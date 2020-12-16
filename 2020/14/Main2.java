import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    public Main2() throws Exception {
        Map<Long, Long> mems = new HashMap<>();
        long orMask = 0L;
        long xMask = 0L;
        while (in.hasNext()) {
            String op = in.next();
            if (op.equals("mask")) {
                String mask = in.next();
                orMask = Long.parseLong(mask.replaceAll("X", "0"), 2);
                xMask = Long.parseLong(mask.replaceAll("1", "0").replaceAll("X", "1"), 2);
            } else { // mem
                long addr = in.nextInt() | orMask;
                long value = in.nextLong();
                long x = ~xMask;
                while (true) {
                    mems.put(x&(addr|xMask), value);
                    if (x==-1) break;
                    x = (x+1) | (~xMask);
                }
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
        new Main2();
    } // }}}
}
