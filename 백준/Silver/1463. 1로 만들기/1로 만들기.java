import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		
		dp[1] = 0;
		if(n > 1) dp[2] = 1;
		if(n > 2) dp[3] = 1;
		
		for (int i = 4; i <= n; i++) {
			int a = Integer.MAX_VALUE;
			int b = dp[i - 1]; 
			if(i % 3 == 0 && i % 2 == 0) a = Math.min(dp[i / 3], dp[i / 2]);
			else if(i % 3 != 0 && i % 2 == 0) a = dp[i / 2];
			else if(i % 3 == 0 && i % 2 != 0)a = dp[i / 3];
			
			dp[i] = Math.min(a, b) + 1;
		}
		System.out.println(dp[n]);
	}
	
}