import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    static int n, edgeNum;
    static boolean[] visit;
    static boolean[][] edge;

    private static void DFS() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while(!stack.isEmpty()){
            int i = stack.pop();
            visit[i] = true;
            for (int j = 1; j <= n; j++) {
                if(edge[i][j] && !visit[j]) stack.push(j);
            }
        }
    }

    private static int Count() {
        int count = 0;
        for(boolean tf : visit){
            if(tf) count++;
        }
        return count - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        edgeNum = Integer.parseInt(br.readLine());
        edge = new boolean[n+1][n+1];
        visit = new boolean[n+1];

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a][b] = true;
            edge[b][a] = true;
        }
        
        DFS();
        System.out.println(Count());
    }
}