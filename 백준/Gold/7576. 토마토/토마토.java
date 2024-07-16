import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x, y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int m, n;
    static int[][] map;
    static final int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<Tomato> queue = new LinkedList<>();

    private static int BFS() {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tomato.x + dirArr[i][0];
                int nextY = tomato.y + dirArr[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(map[nextX][nextY] == 0) {
                    map[nextX][nextY] = map[tomato.x][tomato.y] + 1;
                    queue.add(new Tomato(nextX, nextY));
                }
            }
        }

        return checkTomato();
    }

    private static int checkTomato() {
        int maxDay = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) return -1;
                else if(maxDay < map[i][j]) maxDay = map[i][j];
            }
        }
        return maxDay - 1;      // 시작이 1이여서 -1 해줘야함.
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) queue.add(new Tomato(i, j));
            }
        }
        System.out.println(BFS());
    }
}