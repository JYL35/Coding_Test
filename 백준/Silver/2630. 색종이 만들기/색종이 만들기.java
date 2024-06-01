import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white, blue;
    static int[][] map;

    private static void colorCount(int startRow, int endRow, int startColumn, int endColumn){
        boolean tf = true;
        for (int i = 0; i < 2; i++) {
            tf = true;
            for (int j = startRow; j < endRow; j++) {
                if(!tf) break;
                for (int k = startColumn; k < endColumn; k++) {
                    if(map[j][k] != i) {
                        tf = false;
                        break;
                    }
                }
            }
            if(tf) {
                if(i == 0) white++;
                else blue++;
                return;
            }
        }
        if(!tf) {
            colorCount(startRow, (startRow + endRow) / 2, startColumn, (startColumn + endColumn) / 2);
            colorCount(startRow, (startRow + endRow) / 2, (startColumn + endColumn) / 2, endColumn);
            colorCount((startRow + endRow) / 2, endRow, startColumn, (startColumn + endColumn) / 2);
            colorCount((startRow + endRow) / 2, endRow, (startColumn + endColumn) / 2, endColumn);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = blue = 0;
        colorCount(0, n, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
}