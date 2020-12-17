import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {
    class MBP { // {{{
        int m;
        int n;
        boolean[][] mtx;

        public MBP(int _m, int _n, boolean[][] _mtx) {
            m = _m;
            n = _n;
            mtx = _mtx;
        }

        int[] matchL;
        int[] matchR;
        public int run() {
            matchL = new int[m];
            matchR = new int[n];
            Arrays.fill(matchL, -1);
            Arrays.fill(matchR, -1);

            int cnt = 0;
            for (int i=0; i<m; i++) {
                boolean[] visited = new boolean[n];
                if (dfs(i, visited)) cnt++;
            }
            return cnt;
        }

        private boolean dfs(int l, boolean[] visited) {
            for (int r=0; r<n; r++) {
                if (!mtx[l][r]||visited[r]) continue;
                visited[r] = true;
                if (matchR[r]==-1||dfs(matchR[r], visited)) {
                    matchL[l] = r;
                    matchR[r] = l;
                    return true;
                }
            }
            return false;
        }

    } // }}}

    boolean[] m = new boolean[1000];
    List<Integer> begins = new ArrayList<>();
    List<Integer> ends = new ArrayList<>();

    void r(String s) {
        String[] tokens = s.split("-");
        int b = Integer.parseInt(tokens[0]);
        int e = Integer.parseInt(tokens[1]);
        for (int i=b; i<=e; i++) m[i] = true;
        begins.add(b);
        ends.add(e);
    }

    public Main() throws Exception {
        String line = null;
        int len = 0;
        while ((line=br.readLine()).length()>0) {
            String[] tokens = line.split(" ");
            int l = tokens.length;
            r(tokens[l-3]);
            r(tokens[l-1]);
            len++;
        }

        br.readLine();   // your
        String[] you = br.readLine().split(",");
        br.readLine();   // empty

        br.readLine();   // nearby
        int ans = 0;
        List<int[]> list = new ArrayList<>();
        while ((line=br.readLine())!=null) {
            String[] tokens = line.split(",");
            int[] arr = new int[len];
            boolean valid = true;
            for (int i=0; i<len; i++) {
                int v = Integer.parseInt(tokens[i]);
                arr[i] = v;
                if (!m[v]) {
                    ans += v;
                    valid = false;
                }
            }
            if (valid) {
                list.add(arr);
            }
        }

        boolean[][] matrix = new boolean[len][len];

        for (int i=0; i<len; i++) {
            int b1 = begins.get(i*2);
            int e1 = ends.get(i*2);
            int b2 = begins.get(i*2+1);
            int e2 = ends.get(i*2+1);
            for (int j=0; j<len; j++) {
                boolean valid = true;
                for (int k=0; k<list.size(); k++) {
                    int v = list.get(k)[j];
                    if (v>=b1&&v<=e1 || v>=b2&&v<=e2) continue;
                    valid = false;
                }
                if (valid) matrix[i][j] = true;
            }
        }

        MBP mbp = new MBP(len, len, matrix);
        mbp.run();

        long ans2 = 1;
        for (int i=0; i<6; i++) {
            ans2 *= Integer.parseInt(you[mbp.matchL[i]]);
        }

        System.out.println(ans);
        System.out.println(ans2);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static void main(String[] args) throws Exception { // {{{
        new Main();
    } // }}}
}
