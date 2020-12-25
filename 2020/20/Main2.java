import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main2 {

    char[][] rotate(char[][] o) {
        int n = o.length;
        char[][] m = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                m[i][j] = o[n-j-1][i];
            }
        }
        return m;
    }

    char[][] flip(char[][] o) {
        int n = o.length;
        char[][] m = new char[n][n];
        for (int i=0; i<n; i++) {
            m[i] = o[n-i-1];
        }
        return m;
    }

    class Tile {
        int id;
        char[][] map;
        Tile up;
        Tile down;
        Tile left;
        Tile right;

        public Tile(int id, char[][] map) {
            this.id = id;
            this.map = map;
        }

        public int getUp() {
            int t = 0;
            for (int i=0; i<10; i++) t = (t<<1) | (map[0][i] == '#' ? 1 : 0);
            return t;
        }

        public int getDown() {
            int t = 0;
            for (int i=0; i<10; i++) t = (t<<1) | (map[9][i] == '#' ? 1 : 0);
            return t;
        }

        public int getLeft() {
            int t = 0;
            for (int i=0; i<10; i++) t = (t<<1) | (map[i][0] == '#' ? 1 : 0);
            return t;
        }

        public int getRight() {
            int t = 0;
            for (int i=0; i<10; i++) t = (t<<1) | (map[i][9] == '#' ? 1 : 0);
            return t;
        }
    }

    char[][] monster = {
        "                  # ".toCharArray(),
        "#    ##    ##    ###".toCharArray(),
        " #  #  #  #  #  #   ".toCharArray(),
    };
    int h = monster.length;
    int w = monster[0].length;

    void find(char[][] map) {
        int n = map.length;
        for (int i=0; i<n-h+1; i++) {
            for (int j=0; j<n-w+1; j++) {
                boolean found = true;
                for (int k=0; k<h; k++) {
                    for (int l=0; l<w; l++) {
                        if (map[i+k][j+l]=='.' && monster[k][l]!=' ') found = false;
                    }
                }
                if (found) {
                    for (int k=0; k<h; k++) {
                        for (int l=0; l<w; l++) {
                            if (monster[k][l]!=' ') map[i+k][j+l] = 'O';
                        }
                    }
                }
            }
        }
    }

    public Main2() throws Exception {
        List<Tile> tiles = new ArrayList<>();

        String line = null;
        int n = 0;
        while ((line=br.readLine()) != null) {
            n++;
            int id = Integer.parseInt(line.substring(5, 9));

            char[][] map = new char[10][];
            for (int i=0; i<10; i++) map[i] = br.readLine().toCharArray();
            tiles.add(new Tile(id, map));
            for (int i=1; i<4; i++) {
                map = rotate(map);
                tiles.add(new Tile(id, map));
            }
            map = flip(map);
            tiles.add(new Tile(id, map));
            for (int i=5; i<8; i++) {
                map = rotate(map);
                tiles.add(new Tile(id, map));
            }

            br.readLine();      // empty
        }

        for (Tile t1: tiles) {
            for (Tile t2: tiles) {
                if (t1.id == t2.id) continue;
                if (t1.getDown()==t2.getUp()) {
                    t1.down = t2;
                    t2.up = t1;
                }
                if (t1.getRight()==t2.getLeft()) {
                    t1.right = t2;
                    t2.left = t1;
                }
            }
        }

        Tile tile = tiles.get(0);
        while (tile.left!=null) tile = tile.left;
        while (tile.up!=null) tile = tile.up;

        int m = (int)sqrt(n);
        char[][] map = new char[m*8][m*8];
        for (int i=0; i<m; i++) {
            Tile t = tile;
            for (int j=0; j<m; j++) {
                for (int k=0; k<8; k++) {
                    for (int l=0; l<8; l++) {
                        map[i*8+k][j*8+l] = t.map[k+1][l+1];
                    }
                }
                t = t.right;
            }
            tile = tile.down;
        }

        find(map);
        for (int i=0; i<3; i++) {
            map = rotate(map);
            find(map);
        }
        map = flip(map);
        find(map);
        for (int i=0; i<3; i++) {
            map = rotate(map);
            find(map);
        }

        int ans = 0;
        for (int i=0; i<m*8; i++) for (int j=0; j<m*8; j++) if (map[i][j]=='#') ans++;
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
