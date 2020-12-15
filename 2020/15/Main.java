import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        int[] m = new int[100000000];
        int i = 2;
        int last = -1;
        last = in.nextInt();
        for (;in.hasNext(); i++) {
            m[last] = i-1;
            last = in.nextInt();
        }

        // for (;i<=2020; i++) {
        for (;i<=30000000; i++) {
            int t = last;
            if (m[last] == 0) {
                last = 0;
            } else {
                last = i-1-m[last];
            }
            m[t] = i-1;
        }
        System.out.println(last);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in)).useDelimiter(",|\\s");
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
