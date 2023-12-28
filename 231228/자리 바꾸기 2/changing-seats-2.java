import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            arr.add(new HashSet<>());
            HashSet<Integer> set = arr.get(i);
            set.add(i);
        }
        int[] board = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            board[i] = i;
        }
        ArrayList<int[]> z = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            z.add(new int[]{a, b});
        }
        for(int i = 0; i <= 3 * k; i++) {
            // System.out.println("i : " + (i + 1) + " " + Arrays.toString(board));
            int[] ints = z.get(i % k);
            int a = ints[0];
            int b = ints[1];
            HashSet<Integer> x = arr.get(board[a]);
            x.add(a);
            HashSet<Integer> y = arr.get(board[b]);
            x.add(b);
            int tmp = board[b];
            board[b] = board[a];
            board[a] = tmp;
            x = arr.get(board[a]);
            x.add(b);
            y = arr.get(board[b]);
            x.add(a);
        }
        HashSet<Integer> hashSet = arr.get(1);
        for(int i = 1; i <= n; i++) {
            HashSet<Integer> ans = arr.get(i);
            System.out.println(ans.size());
        }
    }
}