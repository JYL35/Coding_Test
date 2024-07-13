import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] map, distance;
    //북, 동, 남, 서
    static final int[][] dirArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dirArr[i][0];
                int nextY = node.y + dirArr[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(distance[nextX][nextY] == -1) {
                    queue.add(new Node(nextX, nextY));
                    distance[nextX][nextY] = distance[node.x][node.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        map = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    x = i;
                    y = j;
                }
                else if(map[i][j] == 1) distance[i][j] = -1;
            }
        }

        BFS(x, y);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}