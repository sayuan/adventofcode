import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    // → ↘ ↓ ↙ ← ↖ ↑ ↗
    public static final int[] VR = {0, 1, 1, 1, 0, -1, -1, -1};
    public static final int[] VC = {1, 1, 0, -1, -1, -1, 0, 1};

    public Main() throws Exception {
        char[][] m = new char[100][100];
        Arrays.fill(m[0], 'L');
        Arrays.fill(m[99], 'L');
        for (int r=1; r<99; r++) {
            Arrays.fill(m[r], '.');
            m[r][0] = 'L';
            m[r][99] = 'L';
        }
        for (int r=1; in.hasNext(); r++) {
            String line = in.next();
            for (int c=0; c<line.length(); c++) m[r][c+1] = line.charAt(c);
        }

        int q= 0;
        while (true) {
            char[][] n = new char[100][];
            for (int i=0; i<100; i++) n[i] = m[i].clone();

            int[][] cs = new int[100][100];
            // for (int r=1; r<=98; r++) {
                // for (int c=1; c<=98; c++) {
                    // if (m[r][c]!='#') continue;
                    // for (int i=0; i<8; i++) cs[r+VR[i]][c+VC[i]]++;
                // }
            // }

            for (int i=0; i<4; i++) {
                char[][] t = new char[100][];
                for (int j=0; j<100; j++) t[j] = m[j].clone();
                for (int r=98; r>=1; r--) {
                    for (int c=98; c>=1; c--) {
                        if (t[r+VR[i]][c+VC[i]]=='#') cs[r][c]++;
                        if (t[r][c]=='.') t[r][c] = t[r+VR[i]][c+VC[i]];
                    }
                }
            }
            for (int i=4; i<8; i++) {
                char[][] t = new char[100][];
                for (int j=0; j<100; j++) t[j] = m[j].clone();
                for (int r=1; r<=98; r++) {
                    for (int c=1; c<=98; c++) {
                        if (t[r+VR[i]][c+VC[i]]=='#') cs[r][c]++;
                        if (t[r][c]=='.') t[r][c] = t[r+VR[i]][c+VC[i]];
                    }
                }
            }

            boolean changed = false;
            for (int r=1; r<=98; r++) {
                for (int c=1; c<=98; c++) {
                    if (m[r][c]=='L'&&cs[r][c]==0) {
                        n[r][c] = '#';
                        changed = true;
                    // } else if (m[r][c]=='#'&&cs[r][c]>=4) {
                    } else if (m[r][c]=='#'&&cs[r][c]>=5) {
                        n[r][c] = 'L';
                        changed = true;
                    }
                }
            }
            if (!changed) break;
            m = n;
        }
        int ans = 0;
        for (int r=1; r<=98; r++) for (int c=1; c<=98; c++) if (m[r][c]=='#') ans++;
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
