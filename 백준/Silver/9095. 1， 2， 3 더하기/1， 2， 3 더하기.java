import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int startIndex = 4;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = startIndex; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            sb.append(dp[n]).append("\n");
            if(startIndex < n) startIndex = n + 1;
        }
        System.out.println(sb);
    }
}