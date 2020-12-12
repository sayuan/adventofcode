import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    // E S W N
    int[] VX = {1, 0, -1, 0};
    int[] VY = {0, 1, 0, -1};

    public Main() throws Exception {
        int[] dirs = new int[128];
        dirs['E'] = 0;
        dirs['S'] = 1;
        dirs['W'] = 2;
        dirs['N'] = 3;

        int dir = 0;  // E
        int x = 0;
        int y = 0;
        while (in.hasNext()) {
            String ins = in.next();
            char action = ins.charAt(0);
            int value = Integer.parseInt(ins.substring(1));
            if (action == 'F') {
                x += VX[dir] * value;
                y += VY[dir] * value;
            } else if (action == 'L') {
                dir = (dir - value/90 + 4)%4;
            } else if (action == 'R') {
                dir = (dir + value/90)%4;
            } else {
                x += VX[dirs[action]] * value;
                y += VY[dirs[action]] * value;
            }
        }
        System.out.println(abs(x) + abs(y));

    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
