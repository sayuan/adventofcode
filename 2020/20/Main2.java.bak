import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    char[][] rorate(char[][] o) {
        char[][] m = new char[10][10];
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                m[i][j] = o[10-j-1][i];
            }
        }
        return m;
    }

    char[][] flip(char[][] o) {
        char[][] m = new char[10][10];
        for (int i=0; i<10; i++) {
            m[i] = o[10-i-1];
        }
        return m;
    }

    public Main2() throws Exception {
        // Map<Integer, Integer> counts = new HashMap<>();
        // Map<Integer, int[]> patsMap = new HashMap<>();
        String line = null;
        while ((line=br.readLine()) != null) {
            int tile = Integer.parseInt(line.substring(5, 9));

            char[][][] map = new char[8][10][];
            for (int i=0; i<10; i++) map[0][i] = br.readLine().toCharArray();
            for (int i=1; i<4; i++) map[i] = rorate(map[i-1]);
            map[4] = flip(map[0]);
            for (int i=5; i<8; i++) map[i] = rorate(map[i-1]);

            br.readLine();      // empty
        }

    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
