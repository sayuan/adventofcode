import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Main {

    int swap(int n) {
        return ((n&(1<<0))<<9)
            |  ((n&(1<<1))<<7)
            |  ((n&(1<<2))<<5)
            |  ((n&(1<<3))<<3)
            |  ((n&(1<<4))<<1)
            |  ((n&(1<<5))>>1)
            |  ((n&(1<<6))>>3)
            |  ((n&(1<<7))>>5)
            |  ((n&(1<<8))>>7)
            |  ((n&(1<<9))>>9);
    }

    public Main() throws Exception {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, int[]> patsMap = new HashMap<>();
        String line = null;
        while ((line=br.readLine()) != null) {
            int tile = Integer.parseInt(line.substring(5, 9));

            int top = Integer.parseInt(br.readLine().replaceAll("\\.", "0").replaceAll("#", "1"), 2);
            int left = top >> 9;
            int right = top & 1;
            for (int i=2; i<=9; i++) {
                int t = Integer.parseInt(br.readLine().replaceAll("\\.", "0").replaceAll("#", "1"), 2);
                left = (left<<1) | (t>>9);
                right = (right<<1) | (t&1);
            }
            int bottom = Integer.parseInt(br.readLine().replaceAll("\\.", "0").replaceAll("#", "1"), 2);
            left = (left<<1) | (bottom>>9);
            right = (right<<1) | (bottom&1);

            int[] pats = new int[8];
            pats[0] = top;
            pats[1] = left;
            pats[2] = right;
            pats[3] = bottom;
            for (int i=4; i<8; i++) pats[i] = swap(pats[i-4]);


            patsMap.put(tile, pats);
            for (int i=0; i<8; i++) {
                counts.put(pats[i], counts.getOrDefault(pats[i], 0)+1);
            }

            br.readLine();      // empty
        }

        debug(counts.values());

        long ans = 1;
        for (Map.Entry<Integer, int[]> entry:patsMap.entrySet()) {
            int[] pats = entry.getValue();
            int c = 0;
            for (int i=0; i<8; i++) {
                if (counts.get(pats[i])==2) c++;
            }
            if (c==4) ans *= entry.getKey();
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
