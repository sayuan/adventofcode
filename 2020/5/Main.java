import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    Scanner in = new Scanner(new BufferedInputStream(System.in));
    public Main() throws Exception {
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            String s = in.next();
            int n = 0;
            for (char ch: s.toCharArray()) {
                n <<= 1;
                if (ch=='B' || ch=='R') n |= 1;
            }
            list.add(n);
        }
        Collections.sort(list);
        for (int i=1; i<list.size(); i++) {
            if (list.get(i-1)+1==list.get(i)) continue;
            System.out.println(list.get(i-1)+1);
        }
    }
    public static void main(String[] args) throws Exception {
        new Main();
    }
    public static void debug(Object... arr) {
        System.err.println(Arrays.deepToString(arr));
    }
}
