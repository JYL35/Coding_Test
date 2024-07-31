import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String p = "I";
        for (int i = 0; i < n; i++) {
            p += "OI";
        }

        int count = 0;
        int len = p.length();

        for (int i = 0; i <= m - len; i++) {
            if(s.charAt(i) == 'I') {
                if(p.equals(s.substring(i, i + len))) count++;
            }
        }

        System.out.println(count);
    }

}