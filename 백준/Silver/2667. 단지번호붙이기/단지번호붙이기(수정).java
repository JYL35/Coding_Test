import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static final int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        int houseCnt = 0;
        queue.add(new int[]{i, j});
        visit[i][j] = true;
        while(!queue.isEmpty()) {
            houseCnt++;
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int k = 0; k < 4; k++) {
                int nextX = x + dirArr[k][0];
                int nextY = y + dirArr[k][1];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
                if(visit[nextX][nextY] || map[nextX][nextY] == 0) continue;

                queue.add(new int[]{nextX, nextY});
                visit[nextX][nextY] = true;
            }
        }

        return houseCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Integer> resultQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    resultQ.add(BFS(i, j));
                }
            }
        }

        int[] arr = new int[resultQ.size()];
        for (int i = 0; !resultQ.isEmpty(); i++) {
            arr[i] = resultQ.poll();
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arr.length).append("\n");
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

}
