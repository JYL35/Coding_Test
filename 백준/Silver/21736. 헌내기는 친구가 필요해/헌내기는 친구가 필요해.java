import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static final int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int DFS(int x, int y) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{x, y});
        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            int curX = current[0], curY = current[1];

            if(map[curX][curY] == 'P') count++;

            for (int[] dir : dirArr) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(visit[nextX][nextY] || map[nextX][nextY] == 'X') continue;

                visit[nextX][nextY] = true;
                stack.push(new int[]{nextX, nextY});
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;

        map = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        int result = DFS(x, y);
        System.out.println(result == 0 ? "TT" : result);
    }
}