import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        String in = "598162734";
        int n = 9;
        int[] next = new int[n+1];
        for (int i=0; i<9; i++) next[in.charAt(i)-'0'] = in.charAt((i+1)%n)-'0';

        int cur = in.charAt(0)-'0';
        for (int i=0; i<100; i++) {
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
        String ans = "";
        cur = 1;
        for (int i=1; i<9; i++) {
            cur = next[cur];
            ans += cur;
        }
        System.out.println(ans);
    }

    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
