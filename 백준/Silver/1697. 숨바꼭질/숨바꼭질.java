import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;

    private static int BFS() {
        boolean[] visit = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        int result = -1;

        queue.add(n);
        visit[n] = true;
        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                visit[x] = true;
                if(x == k) return result;
                if(x-1 >= 0 && !visit[x-1]) queue.add(x-1);
                if(x+1 <= 100000 && !visit[x+1]) queue.add(x+1);
                if(x*2 <= 100000 && !visit[x*2]) queue.add(x*2);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(BFS());;
    }
}