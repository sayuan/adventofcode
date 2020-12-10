import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) list.add(in.nextInt());
        Collections.sort(list);
        list.add(list.get(list.size()-1)+3);
        int[] d = new int[4];
        int cur = 0;
        for (int next: list) {
            d[next-cur]++;
            cur = next;
        }
        System.out.print(d[1]*d[3]);

        long[] m = new long[cur+1];
        m[0] = 1;
        for (int next: list) {
            for (int i=max(0, next-3); i<next; i++) m[next] += m[i];
        }
        System.out.println(m[cur]);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
