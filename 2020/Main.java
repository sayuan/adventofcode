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

    public Main() throws Exception {
        Set<String> allIngredients = new HashSet<>();
        Set<String> allAllergens = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();

        String line = null;
        while ((line=br.readLine()) != null) {
            line = line.substring(0, line.length()-1);
            String[] t = line.split(" \\(contains ");
            Set<String> ingredients = new HashSet<>(Arrays.asList(t[0].split(" ")));
            Set<String> allergens = new HashSet<>(Arrays.asList(t[1].split(", ")));

            allAllergens.addAll(allergens);
            allIngredients.addAll(ingredients);
            for (String ingredient: ingredients) {
                counts.put(ingredient, counts.getOrDefault(ingredient, 0)+1);
            }

            for (String allergen: allergens) {
                if (map.containsKey(allergen)) {
                    map.get(allergen).retainAll(ingredients);
                } else {
                    map.put(allergen, new HashSet<>(ingredients));
                }
            }
        }

        Set<String> safeIngredients = new HashSet<>(allIngredients);
        for (Set<String> ingredients: map.values()) {
            safeIngredients.removeAll(ingredients);
        }
        int ans1 = 0;
        for (String ingredient: safeIngredients) {
            ans1 += counts.get(ingredient);
        }
        System.out.println(ans1);

        allIngredients.removeAll(safeIngredients);
        List<String> ingredients = new ArrayList<>(allIngredients);
        List<String> allergens = new ArrayList<>(allAllergens);
        Collections.sort(allergens);
        int n = allergens.size();
        Map<String, Integer> indexs = new HashMap<>();
        for (int i=0; i<n; i++) {
            indexs.put(ingredients.get(i), i);
        }

        boolean[][] mtx = new boolean[n][n];
        for (int l=0; l<n; l++) {
            String allergen = allergens.get(l);
            for (String ingredient: map.get(allergen)) {
                int r = indexs.get(ingredient);
                mtx[l][r] = true;
            }
        }
        String ans2 = "";
        MBP mbp = new MBP(n, n, mtx);
        mbp.run();
        for (int i=0; i<n; i++) {
            ans2 += ingredients.get(mbp.matchL[i])+",";
        }
        ans2 = ans2.substring(0, ans2.length()-1);
        System.out.println(ans2);
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
