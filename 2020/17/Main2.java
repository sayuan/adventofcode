import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    public Main2() throws Exception {
        int n = 8;
        boolean[][][][] m = new boolean[n+14][n+14][1+14][1+14];
        for (int i=0; i<n; i++) {
            char[] line = in.next().toCharArray();
            for (int j=0; j<n; j++) {
                m[i+7][j+7][7][7] = line[j]=='#';
            }
        }

        for (int t=0; t<6; t++) {
            boolean[][][][] m2 = new boolean[n+14][n+14][1+14][1+14];
            for (int i=1; i<n+13; i++) {
                for (int j=1; j<n+13; j++) {
                    for (int k=1; k<1+13; k++) {
                        for (int l=1; l<1+13; l++) {
                            int cnt = 0;
                            for (int a=-1; a<=1; a++) for (int b=-1; b<=1; b++) for (int c=-1; c<=1; c++) for (int d=-1; d<=1; d++) {
                                if (a==0&&b==0&&c==0&&d==0) continue;
                                if (m[i+a][j+b][k+c][l+d]) cnt++;
                            }

                            if (m[i][j][k][l]) {
                                m2[i][j][k][l] = (cnt==2 || cnt==3);
                            } else {
                                m2[i][j][k][l] = (cnt==3);
                            }
                        }
                    }
                }
            }
            m = m2;
        }

        int ans = 0;
        for (int i=0; i<n+14; i++) for (int j=0; j<n+14; j++) for (int k=0; k<1+14; k++) for (int l=0; l<1+14; l++) if (m[i][j][k][l]) ans++;
        System.out.println(ans);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
