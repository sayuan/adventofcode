import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    String[] rules = new String[150];

    String dfs(int i) {
        char ch = rules[i].charAt(0);

        if (ch == '"') {
            rules[i] = rules[i].substring(1, 2);
        // } else if (i==8) {
            // rules[i] = "(" + dfs(42) + ")+";
        // } else if (i==11) {
            // String a = "(" +dfs(42) + ")";
            // String b = "(" +dfs(31) + ")";
            // rules[i] = "(";
            // for (int j=1; j<10; j++) {
                // if (j != 1) rules[i] += "|";
                // rules[i] += "(";
                // for (int k=0; k<j; k++) rules[i] += a;
                // for (int k=0; k<j; k++) rules[i] += b;
                // rules[i] += ")";
            // }
            // rules[i] += ")";
        } else if (Character.isDigit(ch)) {
            String[] rs = rules[i].split(" \\| ");
            rules[i] = "(";
            for (int j=0; j<rs.length; j++) {
                if (j != 0) rules[i] += "|";
                rules[i] += "(";
                for (String next: rs[j].split(" ")) {
                    rules[i] += dfs(Integer.parseInt(next));
                }
                rules[i] += ")";
            }
            rules[i] += ")";
        }
        return rules[i];
    }

    public Main() throws Exception {
        String line = null;
        while (!(line=br.readLine()).isEmpty()) {
            int p = line.indexOf(':');
            rules[Integer.parseInt(line.substring(0, p))] = line.substring(p+2);
        }

        String pattern = dfs(0);
        int ans = 0;
        while ((line=br.readLine())!=null) {
            if (line.matches(pattern)) ans++;
        }
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
