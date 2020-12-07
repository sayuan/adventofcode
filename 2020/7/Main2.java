import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main2 {

    Map<String, List<String>> map1 = new HashMap<>();
    Map<String, List<Integer>> map2 = new HashMap<>();
    public Main2() throws Exception {
        while (in.hasNext()) {
            String outer = in.next() + " " + in.next();
            in.next();  // bags
            in.next();  // contain
            List<String> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            while (true) {
                String amount = in.next();
                if (amount.equals("no")) {
                    in.next();  // other
                    in.next();  // bags.
                    break;
                }
                String inner = in.next() + " " + in.next();
                list1.add(inner);
                list2.add(Integer.parseInt(amount));

                String bag = in.next();
                if (bag.endsWith(".")) break;
            }
            map1.put(outer, list1);
            map2.put(outer, list2);
        }
        debug(r("shiny gold")-1);
    }

    long r(String bag) {
        long ans = 1;
        List<String> list1 = map1.get(bag);
        if (list1!=null) {
            List<Integer> list2 = map2.get(bag);
            for (int i=0; i<list1.size(); i++) {
                ans += list2.get(i) * r(list1.get(i));
            }
        }
        return ans;
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static StringBuilder buf = new StringBuilder();
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
        System.out.print(buf);
    } // }}}
}
