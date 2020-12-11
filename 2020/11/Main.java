import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        int[][] m = new int[100][100];
        for (int r=1; in.hasNext(); r++) {
            String line = in.next();
            for (int c=0; c<line.length(); c++) m[r][c+1] = line.charAt(c)=='.'?0:1;
        }

        while (true) {
            int[][] n = new int[100][100];
            boolean changed = false;
            for (int r=1; r<=98; r++) {
                for (int c=1; c<=98; c++) {
                    int o = 0;
                    for (int dr=-1; dr<=1; dr++) {
                        for (int dc=-1; dc<=1; dc++) {
                            if (dr==0&&dc==0) continue;
                            if (m[r+dr][c+dc] == 2) o++;
                        }
                    }
                    n[r][c] = m[r][c];
                    if (m[r][c]==1&&o==0) {
                        n[r][c] = 2;
                        changed = true;
                    } else if (m[r][c]==2&&o>=4) {
                        n[r][c] = 1;
                        changed = true;
                    }
                }
            }
            if (!changed) break;
            m = n;
        }
        int ans = 0;
        for (int r=1; r<=98; r++) for (int c=1; c<=98; c++) if (m[r][c]==2) ans++;
        System.out.println(ans);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
