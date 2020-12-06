import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    public Main2() throws Exception {
        String line = null;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char ch='a'; ch<='z'; ch++) set.add(ch);
        while ((line=br.readLine()) != null) {
            if (line.length()==0) {
                ans += set.size();
                for (char ch='a'; ch<='z'; ch++) set.add(ch);
            } else {
                for (char ch='a'; ch<='z'; ch++) if (line.indexOf(ch)<0) set.remove(ch);
            }
        }
        debug(ans);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
