import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    // E S W N
    int[] VX = {1, 0, -1, 0};
    int[] VY = {0, 1, 0, -1};

    public Main2() throws Exception {
        int[] dirs = new int[128];
        dirs['E'] = 0;
        dirs['S'] = 1;
        dirs['W'] = 2;
        dirs['N'] = 3;

        int dx = 10;
        int dy = -1;

        int x = 0;
        int y = 0;
        while (in.hasNext()) {
            String ins = in.next();
            char action = ins.charAt(0);
            int value = Integer.parseInt(ins.substring(1));
            if (action == 'F') {
                x += dx * value;
                y += dy * value;
            } else if (action == 'L') {
                for (int i=0; i<value; i+=90) {
                    int t = dx;
                    dx = dy;
                    dy = -t;
                }
            } else if (action == 'R') {
                for (int i=0; i<value; i+=90) {
                    int t = dy;
                    dy = dx;
                    dx = -t;
                }
            } else {
                dx += VX[dirs[action]] * value;
                dy += VY[dirs[action]] * value;
            }
        }
        System.out.println(abs(x) + abs(y));

    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
