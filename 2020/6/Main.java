import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        String line = null;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        while ((line=br.readLine()) != null) {
            if (line.length()==0) {
                ans += set.size();
                set.clear();
            } else {
                for (char ch: line.toCharArray()) set.add(ch);
            }
        }
        debug(ans);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
