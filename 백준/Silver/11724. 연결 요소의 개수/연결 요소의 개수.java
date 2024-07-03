import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visit;
    static boolean[][] graph;

    private static void DFS(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visit[u]){
                visit[u] = true;
                for (int v = 1; v <= n; v++) {
                    if(graph[u][v] && !visit[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        graph = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if(!visit[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }
}