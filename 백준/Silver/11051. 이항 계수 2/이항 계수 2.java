import java.io.*;
import java.util.StringTokenizer;


public class Main {
	
	private static int binomial(int n, int k) {
		int[][] dp = new int[n+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) dp[i][j] = 1;
				else dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
				
				if(i == n && j == k) return dp[n][k];
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(binomial(n, k));
	}
	
}