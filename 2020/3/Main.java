import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    // {{{
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    public Main() throws Exception {
        char[][] map = new char[500][];
        int R;
        for (R=0; in.hasNext(); R++) {
            map[R] = in.next().toCharArray();
        }

        int C = map[0].length;
        int r = 0;
        int c = 0;
        int ans = 0;
        while (r<R) {
            if (map[r][c]=='#') ans++;
            r++;
            c = (c+3)%C;
        }

        System.out.println(ans);


    }
    public static void main(String[] args) throws Exception {
        new Main();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    }
    // }}}
}
