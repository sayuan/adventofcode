import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {

    Map<String, Set<String>> map = new HashMap<>();
    Set<String> ans = new HashSet<>();
    public Main() throws Exception {
        while (in.hasNext()) {
            String outer = in.next() + " " + in.next();
            in.next();  // bags
            in.next();  // contain
            while (true) {
                String amount = in.next();
                if (amount.equals("no")) {
                    in.next();  // other
                    in.next();  // bags.
                    break;
                }
                String inner = in.next() + " " + in.next();

                Set<String> s = map.getOrDefault(inner, new HashSet<>());
                s.add(outer);
                map.put(inner, s);

                String bag = in.next();
                if (bag.endsWith(".")) break;
            }
        }
        r("shiny gold");
        debug(ans.size());
    }

    void r(String bag) {
        for (String outer: map.getOrDefault(bag, new HashSet<>())) {
            if (!ans.contains(outer)) {
                ans.add(outer);
                r(outer);
            }
        }
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static StringBuilder buf = new StringBuilder();
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
        System.out.print(buf);
    } // }}}
}
