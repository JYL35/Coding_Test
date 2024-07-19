import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static String[][] map;
    static boolean[][] visit;
    static int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int DFS(int x, int y) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{x, y});
        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            if(!visit[current[0]][current[1]]) {
                visit[current[0]][current[1]] = true;
                if(map[current[0]][current[1]].equals("P")) count++;
                for (int i = 0; i < 4; i++) {
                    int nextX = current[0] + dirArr[i][0];
                    int nextY = current[1] + dirArr[i][1];

                    if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                    if(visit[nextX][nextY] || map[nextX][nextY].equals("X")) continue;

                    stack.push(new int[]{nextX, nextY});
                }
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

        map = new String[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j];
                if(map[i][j].equals("I")) {
                    x = i;
                    y = j;
                }
            }
        }

        int result = DFS(x, y);
        if(result == 0) System.out.println("TT");
        else System.out.println(result);
    }
}