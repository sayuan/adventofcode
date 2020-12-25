import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        boolean[][] map = new boolean[1000][1000];
        int ans = 0;
        while (in.hasNext()) {
            String l = in.next();
            int x = 500;
            int y = 500;
            while (!l.isEmpty()) {
                if (l.startsWith("e")) {
                    x += 2;
                    l = l.substring(1);
                } else if (l.startsWith("se")) {
                    x += 1;
                    y -= 1;
                    l = l.substring(2);
                } else if (l.startsWith("sw")) {
                    x -= 1;
                    y -= 1;
                    l = l.substring(2);
                } else if (l.startsWith("w")) {
                    x -= 2;
                    l = l.substring(1);
                } else if (l.startsWith("nw")) {
                    x -= 1;
                    y += 1;
                    l = l.substring(2);
                } else if (l.startsWith("ne")) {
                    x += 1;
                    y += 1;
                    l = l.substring(2);
                }
            }
            map[x][y] = !map[x][y];
            if (map[x][y]) ans++;
            else ans--;
        }
        System.out.println(ans);

        int ans2 = 0;
        for (int i=0; i<100; i++) {
            boolean[][] next = new boolean[1000][1000];
            ans2 = 0;
            for (int x=2; x<998; x++) for (int y=2; y<998; y++) if (((x^y)&1)==0) {
                next[x][y] = map[x][y];
                int b = 0;
                for (int dx=-2; dx<=2; dx++) for (int dy=-1; dy<=1; dy++) if (abs(dx)+abs(dy)==2) {
                    if (map[x+dx][y+dy]) b++;
                }
                if (map[x][y] && (b==0 || b>2)) next[x][y] = false;
                else if (!map[x][y] && b==2) next[x][y] = true;
                if (next[x][y]) ans2++;
            }
            map = next;
        }
        System.out.println(ans2);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
