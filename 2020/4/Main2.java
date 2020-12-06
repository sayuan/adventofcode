import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Main2() throws Exception {
        int ans = 0;
        int m = 0;
        String line = null;
        while ((line=br.readLine())!=null) {
            if (line.length()==0) {
                if (m == 0x7f) ans++;
                m = 0;
            } else {
                for (String t: line.split(" ")) {
                    String value = t.substring(4);
                    switch (t.substring(0, 3)) {
                        case "byr":
                            if (value.matches("19[2-9][0-9]|200[0-2]")) m |= 1;
                            break;
                        case "iyr":
                            if (value.matches("201[0-9]|2020")) m |= 2;
                            break;
                        case "eyr":
                            if (value.matches("202[0-9]|2030")) m |= 4;
                            break;
                        case "hgt":
                            if (value.matches("(1[5-9][0-9]|19[1-3])cm|(59|6[0-9]|7[0-6])in")) m |= 8;
                            break;
                        case "hcl":
                            if (value.matches("#[0-9a-f]{6}")) m |= 16;
                            break;
                        case "ecl":
                            if (value.matches("amb|blu|brn|gry|grn|hzl|oth")) m |= 32;
                            break;
                        case "pid":
                            if (value.matches("[0-9]{9}")) m |= 64;
                            break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception {
        new Main2();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    }
}
