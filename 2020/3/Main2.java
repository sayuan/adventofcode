import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    // {{{
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    public Main2() throws Exception {
        char[][] map = new char[500][];
        int R;
        for (R=0; in.hasNext(); R++) {
            map[R] = in.next().toCharArray();
        }

        int C = map[0].length;
        long ans = 1;

        int[] dr = {1,1,1,1,2};
        int[] dc = {1,3,5,7,1};

        for (int i=0; i<dr.length; i++) {
            int r = 0;
            int c = 0;
            int t = 0;
            while (r<R) {
                if (map[r][c]=='#') t++;
                r += dr[i];
                c = (c+dc[i])%C;
            }
            ans *= t;
        }

        System.out.println(ans);


    }
    public static void main(String[] args) throws Exception {
        new Main2();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    }
    // }}}
}
