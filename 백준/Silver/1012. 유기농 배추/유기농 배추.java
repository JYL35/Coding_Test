import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static boolean[][] graph, visit;
    static int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n, m, k;

    private static void DFS(int x, int y){
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(x, y));

        while(!stack.isEmpty()){
            Node node = stack.pop();
            visit[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int next_x = node.x + dirArr[i][0];
                int next_y = node.y + dirArr[i][1];

                if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) continue;
                if(!visit[next_x][next_y] && graph[next_x][next_y]){
                    stack.push(new Node(next_x, next_y));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int count = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new boolean[n][m];
            visit = new boolean[n][m];

            while(k-- > 0){
                String[] s = br.readLine().split(" ");
                graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visit[i][j] && graph[i][j]){
                        DFS(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}