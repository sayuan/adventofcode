import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    class Node {
        boolean leaf;
        char symbol;
        List<List<Integer>> children;
        public Node(String rule) {
            char ch = rule.charAt(0);
            if (ch == '"') {
                leaf = true;
                symbol = rule.charAt(1);
            } else {
                children = new ArrayList<>();
                for (String a: rule.split(" \\| ")) {
                    List<Integer> list = new ArrayList<>();
                    for (String b: a.split(" ")) list.add(Integer.parseInt(b));
                    children.add(list);
                }
            }
        }
    }

    Node[] nodes = new Node[200];

    int dfs(int i, String s) {
        Node node = nodes[i];
        if (node.leaf) {
            return (s.length()>=1 && node.symbol==s.charAt(0))?1:-1;
        } else {
l:
            for (List<Integer> child: node.children) {
                String t = s;
                for (Integer next: child) {
                    int r = dfs(next, t);
                    if (r==-1) continue l;
                    t = t.substring(r);
                }
                return s.length() - t.length();
            }
            return -1;
        }
    }

    public Main2() throws Exception {
        String line = null;
        while (!(line=br.readLine()).isEmpty()) {
            int p = line.indexOf(':');
            nodes[Integer.parseInt(line.substring(0, p))] = new Node(line.substring(p+2));
        }

        int ans = 0;
        while ((line=br.readLine())!=null) {
            // if (dfs(0, line)==line.length()) ans++;
l:
            for (int i=1; ;i++) {
                int r = dfs(42, line);
                if (r==-1) break l;
                line = line.substring(r);
                if (i>=2) {
                    String t = line;
                    for (int j=1; ; j++) {
                        int r2 = dfs(31, t);
                        if (r2==-1) break;
                        t = t.substring(r2);
                        if (i>j && t.isEmpty()) {
                            ans++;
                            break l;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static Scanner in = new Scanner(new BufferedInputStream(System.in));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main2();
    } // }}}
}
