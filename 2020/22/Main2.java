import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    boolean combat(LinkedList<Integer> a, LinkedList<Integer> b) {
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            int ha = a.hashCode();
            int hb = b.hashCode();

            if (setA.contains(ha) || setB.contains(hb)) return true;

            setA.add(ha);
            setB.add(hb);

            int ca = a.removeFirst();
            int cb = b.removeFirst();

            boolean aWin;
            if (ca <= a.size() && cb <= b.size()) {
                aWin = combat(new LinkedList<>(a.subList(0, ca)), new LinkedList<>(b.subList(0, cb)));
            } else {
                aWin = ca > cb;
            }
            if (aWin) {
                a.addLast(ca);
                a.addLast(cb);
            } else {
                b.addLast(cb);
                b.addLast(ca);
            }
        }
        return !a.isEmpty();
    }

    public Main2() throws Exception {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();

        String line = br.readLine();  // Player 1
        while (!(line=br.readLine()).isEmpty()) {
            a.addLast(Integer.parseInt(line));
        }
        br.readLine();  // Player 2
        while ((line=br.readLine()) != null) {
            b.addLast(Integer.parseInt(line));
        }

        combat(a, b);

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
        new Main2();
    } // }}}
}
