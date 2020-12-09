import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        List<Long> list = new ArrayList<>();
        while (in.hasNext()) list.add(in.nextLong());

        Set<Long> set = new HashSet<>();
        for (int i=0; i<25; i++) set.add(list.get(i));
        Long target = -1L;
        for (int i=25; i<list.size(); i++) {
            boolean valid = false;
            for (int j=0; j<25; j++) {
                if (set.contains(list.get(i)-list.get(i-j-1))) valid = true;
            }
            if (!valid) {
                target = list.get(i);
                break;
            }
            set.remove(list.get(i-25));
            set.add(list.get(i));
        }
        System.out.println(target);

        int l = 0;
        int r = 2;
        long cur = list.get(0) + list.get(1);
        while (r<list.size()) {
            if (cur<target) {
                cur += list.get(r);
                r++;
            } else if (cur>target) {
                cur -= list.get(l);
                l++;
            } else {
                long min = Collections.min(list.subList(l, r));
                long max = Collections.max(list.subList(l, r));
                System.out.println(min+max);
                break;
            }
        }

    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
