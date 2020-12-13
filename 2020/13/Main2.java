import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    public static long lcm(long a, long b) {
        return (long)a*b/gcd(a,b);
    }

    public static long gcd(long a, long b) {
        return b==0?a:gcd(b, a%b);
    }

    public Main2() throws Exception {
        int timestamp = in.nextInt();
        String[] schedules = in.next().split(",");
        int[] d = new int[10];
        int[] ids = new int[10];
        int len = 0;
        for (int i=0; i<schedules.length; i++) {
            if (schedules[i].equals("x")) continue;
            int id = Integer.parseInt(schedules[i]);
            d[len] = i;
            ids[len] = id;
            len++;
        }
        long c = ids[0];
        long lcm = c;
        for (int i=1; i<len; i++) {
            while ((c+d[i])%ids[i] != 0) c+= lcm;
            lcm = lcm(lcm, ids[i]);
        }
        System.out.println(c);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
