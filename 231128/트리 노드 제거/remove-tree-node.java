import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int root, cnt, target;
    static boolean[] visited;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            int v = Integer.parseInt(s[i]);
            if(v == -1) {
                parent[i] = -1;
                root = i;
            } else {
                parent[i] = v;
                arr.get(v).add(i);
            }
        }

        target = Integer.parseInt(br.readLine());
        dp = new int[n];
        parent[target] = -1;
        cnt = 0;
        visited = new boolean[n];
        visited[root] = true;
        dfs(root);
        if(target == 0) System.out.println(0);
        else System.out.println(dp[root]);
    }
    static int dfs(int start) {
        if(dp[start] != 0) {
            return dp[start] = 1;
        }

        for(int i = 0; i < arr.get(start).size(); i++) {
            int next = arr.get(start).get(i);
            if(!visited[next]) {
                visited[next] = true;
                if(next != target) {
                    dp[start] += dfs(next);
                }
            }
        }
        return 1;
    }
}