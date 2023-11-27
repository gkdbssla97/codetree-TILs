import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
    // 여기에 코드를 작성해주세요.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int t = Integer.parseInt(s[1]);
    String[] board = new String[n];

        HashMap<String, List<String>> map = new LinkedHashMap<>();
        HashMap<String, Integer> index = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            board[i] = word;
            index.put(word, i + 1);
        }

        Arrays.sort(board);

        // System.out.println(Arrays.toString(board));

        for(int i = 0; i < t; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            String b = s[1];

            //시작위치 검색
            int left = 0;
            int right = board.length - 1;
            // int midS = -1;
            // int start = -1;
            // while(left <= right) {
            //     midS = (left + right) / 2;

            //     if(board[midS].startsWith(b)) {
            //         left = midS + 1;
            //     } else {
            //         right = midS - 1;
            //     }
            // }
            // start = midS;
            // System.out.println("start: " + start);
            // //끝 위치 검색
            // left = start;
            // right = board.length -1;
            // int midE = -1;
            // while(left <= right) {
            //     midE = (left + right) / 2;

            //     if(board[midE].startsWith(b)) {
            //         break;
            //     } else {
            //         left = midE + 1;
            //     }
            // }
            // int end = midE;
            int start = -1;
            int end = -1;
            while(left <= right) {
                if(board[left].startsWith(b) && board[right].startsWith(b)) {
                    start = left;
                    end = right;
                    break;
                } else if(board[left].startsWith(b)) {
                    start = left;
                    right--;
                } else if(board[right].startsWith(b)) {
                    end = right;
                    left++;
                } else {
                    right--;
                    left++;
                }
            }
            // if(b.equals("q")) System.out.println(start + " " + end);
            if(start + a - 1 >= board.length || start + a - 1 > end) {
                System.out.println(-1);
            } else if(index.get(board[start + a - 1]) != null) {
                System.out.println(index.get(board[start + a - 1]));
            } else {
                // if(index.get(board[start + a - 1]) == null) {
                    System.out.println(-1);
                // }
            }
        }
    }
}
// 이후 이를 줄이기 위한 방향으로는 일일이 모든 단어를 살펴보기 보다는, 주어진 타겟 단어로 시작하는 문자열의 시작 위치와 끝 위치를 각각 이진탐색을 이용
/**
5 3
da
aa
ab
ba
bc
2 a
2 b
1 d
**/