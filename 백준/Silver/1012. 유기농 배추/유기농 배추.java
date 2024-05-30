import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph, visit;
    static Stack<Integer[]> stack = new Stack<>();

    private static int warmCount(int n, int m) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(graph[i][j] && !visit[i][j]){
                    path(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void path(int i, int j){
        int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Integer[] arr = {i, j};
        stack.push(arr);
        int x = stack.peek()[0];
        int y = stack.pop()[1];
        int dir = 0;
        while(dir < 4){
            int next_i = x + dirArr[dir][0];
            int next_j = y + dirArr[dir][1];
            if(!graph[next_i][next_j] || visit[next_i][next_j]) {
                dir++;
            }
            else if(graph[next_i][next_j] && !visit[next_i][next_j]){
                Integer[] tempArr = {next_i, next_j};
                stack.push(tempArr);
                visit[next_i][next_j] = true;
                path(next_i, next_j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new boolean[n+2][m+2];
            visit = new boolean[n+2][m+2];

            while(k-- > 0){
                String[] s = br.readLine().split(" ");
                graph[Integer.parseInt(s[0])+1][Integer.parseInt(s[1])+1] = true;
            }
            sb.append(warmCount(n, m)).append("\n");
        }
        System.out.println(sb);
    }
}