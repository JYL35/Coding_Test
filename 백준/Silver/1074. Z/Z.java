import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;

    static void Divide(int x, int y, int mid) {
        if(mid == 0) return;

        if(x < mid && y < mid) Divide(x, y, mid / 2);
        else if(x < mid) {
            result += mid * mid;
            Divide(x, y - mid, mid / 2);
        }
        else if(y < mid) {
            result += mid * mid * 2;
            Divide(x - mid, y, mid / 2);
        }
        else {
            result += mid * mid * 3;
            Divide(x - mid, y - mid, mid / 2);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Divide(r, c, (int)Math.pow(2, n) / 2);
        System.out.println(result);
    }
}