import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Main() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("byr", 0);
        map.put("iyr", 1);
        map.put("eyr", 2);
        map.put("hgt", 3);
        map.put("hcl", 4);
        map.put("ecl", 5);
        map.put("pid", 6);
        map.put("cid", 7);

        int ans = 0;
        int m = 0;
        String line = null;
        while ((line=br.readLine())!=null) {
            if (line.length()==0) {
                if (((m+1) & 0x7f) == 0) ans++;
                m = 0;
            } else {
                for (String t: line.split(" ")) {
                    m |= 1 << map.get(t.substring(0, 3));
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception {
        new Main();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    }
}
