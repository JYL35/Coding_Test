import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tBundle = 0;
        int pBundle = n / p;
        int pens = n % p;
        for (int i = 0; i < 6; i++) {
            tBundle += size[i] / t;
            if(size[i] % t != 0) tBundle++;
        }
        System.out.println(tBundle);
        System.out.printf("%d %d", pBundle, pens);
    }
}