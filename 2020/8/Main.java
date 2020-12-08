import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        List<String> ops = new ArrayList<>();
        List<Integer> args = new ArrayList<>();
        while (in.hasNext()) {
            ops.add(in.next());
            args.add(in.nextInt());
        }
        Set<Integer> visited = new HashSet<>();
        int acc = 0;
        int cur = 0;
        while (true) {
            if (visited.contains(cur)) break;
            visited.add(cur);
            String op = ops.get(cur);
            Integer arg = args.get(cur);
            if (op.equals("nop")) {
                cur++;
            } else if (op.equals("acc")) {
                acc += arg;
                cur++;
            } else if (op.equals("jmp")) {
                cur += arg;
            } else {
                System.exit(1);
            }
        }
        System.out.println(acc);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
