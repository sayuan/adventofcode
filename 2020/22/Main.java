import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        Deque<Integer> a = new LinkedList<>();
        Deque<Integer> b = new LinkedList<>();

        String line = br.readLine();  // Player 1
        while (!(line=br.readLine()).isEmpty()) {
            a.addLast(Integer.parseInt(line));
        }
        br.readLine();  // Player 2
        while ((line=br.readLine()) != null) {
            b.addLast(Integer.parseInt(line));
        }

        while (!a.isEmpty() && !b.isEmpty()) {
            int ca = a.removeFirst();
            int cb = b.removeFirst();
            if (ca > cb) {
                a.addLast(ca);
                a.addLast(cb);
            } else if (ca < cb) {
                b.addLast(cb);
                b.addLast(ca);
            } else {
                System.out.println("!!!");
                System.exit(1);
            }
        }
        int ans = 0;
        a.addAll(b);
        int l = a.size();
        for (Integer v: a) ans += v*l--;
        System.out.println(ans);

    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
