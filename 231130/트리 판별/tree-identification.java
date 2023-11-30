import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited, used;
    static int[] deg;
    static int root;
    static boolean isTree = true;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        used = new boolean[10001];
        visited = new boolean[10001];
        deg = new int[10001];

        for(int i = 0; i <= 10_000; i++) {
            arr.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            arr.get(start).add(end);
            
            used[start] = used[end] = true;
            deg[end]++;
        }
        
        for(int i = 1; i <= 10000; i++) {
            if(used[i] && deg[i] == 0) {
                if(root != 0) {
                    isTree = false;
                }
                root = i;
            }
        }
        if(root == 0) {
            isTree = false;
        }
        for(int i = 1; i <= 10000; i++) {
            if(used[i] && i != root && deg[i] != 1) {
                isTree = false;
            }
        }
        if(isTree && root != 0) {
            visited[root] = true;
            dfs(root);
        }
        for(int i = 1; i <= 10000; i++) {
            if(used[i] && !visited[i]) isTree = false;
        }
        if(isTree) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(int start) {

        for(int i = 0; i < arr.get(start).size(); i++) {
            int next = arr.get(start).get(i);
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }

        return;
    }
}