import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        int timestamp = in.nextInt();
        String[] schedules = in.next().split(",");
        int min = 1<<30;
        int ans = 0;
        for (int i=0; i<schedules.length; i++) {
            if (schedules[i].equals("x")) continue;
            int id = Integer.parseInt(schedules[i]);
            int t = (timestamp+id-1)/id*id;
            if (t<min) {
                min = t;
                ans = (t-timestamp)*id;
            }
        }
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
