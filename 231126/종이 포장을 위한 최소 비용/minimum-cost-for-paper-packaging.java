import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] stone = new int[n];
        int[] box = new int[m];

        for(int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(br.readLine());
        }
    }
}