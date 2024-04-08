import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] dp = new String[41];
		
		dp[0] = "1 0";
		dp[1] = "0 1";
		
		StringBuilder sb = new StringBuilder();
		int max = 1;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			for (int j = max + 1; j <= num; j++) {
				String[] s1 = dp[j-2].split(" ");
				String[] s2 = dp[j-1].split(" ");
				int zero = Integer.parseInt(s1[0]) + Integer.parseInt(s2[0]);
				int one = Integer.parseInt(s1[1]) + Integer.parseInt(s2[1]);
				dp[j] = zero + " " + one;
			}
			sb.append(dp[num]).append("\n");
			if(max > 2) max = num;
		}
		System.out.println(sb);
	}
	
}