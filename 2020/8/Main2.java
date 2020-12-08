import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    public Main2() throws Exception {
        List<String> ops = new ArrayList<>();
        List<Integer> args = new ArrayList<>();
        while (in.hasNext()) {
            ops.add(in.next());
            args.add(in.nextInt());
        }
        int l = ops.size()-1;
        boolean[][] m = new boolean[l][l];
        for (int i=0; i<l-1; i++) {
            String op = ops.get(i);
            Integer arg = args.get(i);
            if (op.equals("nop")) {
                m[i][i+1] = true;
            } else if (op.equals("acc")) {
                m[i][i+1] = true;
            } else if (op.equals("jmp")) {
                m[i][i+arg] = true;
            } else {
                System.exit(1);
            }
        }

        for (int k=0; k<l; k++) for (int i=0; i<l; i++) for (int j=0; j<l; j++) m[i][j] |= m[i][k] & m[k][j];

        boolean fixed = false;
        int acc = 0;
        int cur = 0;
        while (cur<l) {
            String op = ops.get(cur);
            Integer arg = args.get(cur);
            if (op.equals("nop")) {
                if (!fixed && m[cur+arg][l-1]) {
                    fixed = true;
                    cur += arg;
                    continue;
                }
                cur++;
            } else if (op.equals("acc")) {
                acc += arg;
                cur++;
            } else if (op.equals("jmp")) {
                if (!fixed && m[cur+1][l-1]) {
                    fixed = true;
                    cur++;
                    continue;
                }
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
        new Main2();
    } // }}}
}
