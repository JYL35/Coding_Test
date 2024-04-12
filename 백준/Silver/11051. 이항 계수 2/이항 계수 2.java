import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static final int div = 10007;
	
	private static int binomial(int n, int k) {
		if (dp[n][k] > 0) return dp[n][k];
		
		if (k == 0 || k == n) return dp[n][k] = 1;
		
		return dp[n][k] = (binomial(n-1, k) + binomial(n-1, k-1)) % div;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][n+1];
		
		System.out.println(binomial(n, k));
    }
}