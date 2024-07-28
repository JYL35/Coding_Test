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

    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dirArr[i][0];
                int nextY = y + dirArr[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(visit[nextX][nextY] || maze[nextX][nextY] == 0) continue;

                maze[nextX][nextY] = maze[x][y] + 1;
                visit[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY});
            }
        }
        return maze[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(BFS());
    }

}