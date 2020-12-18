import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    public Main() throws Exception {
        long ans = 0;
        String input = null;
        while ((input=br.readLine()) != null) {
            String[] tokens = input.replaceAll("\\(", "\\( ").replaceAll("\\)", " \\)").split(" ");

            Stack<String> s1 = new Stack<String>();
            List<String> list = new ArrayList<>();
            Stack<Long> s2 = new Stack<Long>();

            for (String token: tokens) {
                char f = token.charAt(0);
                if (Character.isDigit(f)) {
                    list.add(token);
                } else if (f=='(') {
                    s1.push(token);
                } else if (f==')') {
                    while (!s1.peek().equals("(")) list.add(s1.pop());
                    s1.pop();
                // } else {
                    // while (!s1.empty()&&!s1.peek().equals("(")) list.add(s1.pop());
                    // s1.push(token);
                } else if (f=='+') {
                    while (!s1.empty()&&!s1.peek().equals("(")&&!s1.peek().equals("*")) list.add(s1.pop());
                    s1.push(token);
                } else if (f=='*') {
                    while (!s1.empty()&&!s1.peek().equals("(")) list.add(s1.pop());
                    s1.push(token);
                }
            }
            while (!s1.empty()) list.add(s1.pop());

            for (String token: list) {
                char f = token.charAt(0);
                if (Character.isDigit(f)) {
                    s2.push(Long.parseLong(token));
                } else {
                    long b = s2.pop();
                    long a = s2.pop();
                    if (f=='+') s2.push(a+b);
                    else if (f=='*') s2.push(a*b);
                }
            }
            ans += s2.pop();
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
