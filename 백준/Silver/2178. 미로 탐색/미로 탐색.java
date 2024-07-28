import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] maze;
    static boolean[][] visit;
    static int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        //int minCount = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dirArr[i][0];
                int nextY = y + dirArr[i][1];

                if(nextX < 1 || nextY < 1 || nextX > n || nextY > m) continue;
                if(maze[nextX][nextY] == 0 || maze[nextX][nextY] <= maze[x][y] + 1) continue;

                maze[nextX][nextY] = maze[x][y] + 1;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                if(arr[j-1].equals("1")) maze[i][j] = Integer.MAX_VALUE;
            }
        }
        maze[1][1] = 1;
        BFS();
        System.out.println(maze[n][m]);
    }

}