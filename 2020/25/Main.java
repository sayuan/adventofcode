import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public static final int MOD = 20201227;

    public Main() throws Exception {
        long c = 1;
        long t = -1;
        int a = -1;
        int b = -1;
        for (int i=0; i<MOD; i++) {
            // if (c==17807724) b = i;
            // if (c==15628416) a = i;
            if (c==11161639) b = i;
            c = (c*7)%MOD;
        }
        c = 1;
        // for (int i=0; i<a; i++) c = (c*7)%MOD;
        for (int i=0; i<b; i++) c = (c*15628416)%MOD;
        debug(c);
        
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
