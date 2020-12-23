import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    public Main2() throws Exception {
        String in = "598162734";
        int n = 1000000;
        int[] next = new int[n+1];
        for (int i=0; i<9; i++) next[in.charAt(i)-'0'] = in.charAt((i+1)%9)-'0';
        for (int i=10; i<=n; i++) next[i] = i+1;
        next[in.charAt(8)-'0'] = 10;
        next[n] = in.charAt(0)-'0';

        int cur = in.charAt(0)-'0';
        for (int i=0; i<10000000; i++) {
            int a = next[cur];
            int b = next[a];
            int c = next[b];
            int dst = cur;
            do {
                dst = dst==1?n:dst-1;
            } while (dst==a||dst==b||dst==c);
            next[cur] = next[c];
            next[c] = next[dst];
            next[dst] = a;
            cur = next[cur];
        }
        int a = next[1];
        int b = next[a];
        System.out.println(1L*a*b);
    }

    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
