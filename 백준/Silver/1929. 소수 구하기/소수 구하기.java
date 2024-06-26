import java.io.*;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[n + 1];
		
		arr[0] = true;
		arr[1] = true;
		
		for(int i = 2; i * i <= n; i++) {
			if(!arr[i]) {
				for(int j = i * i; j <= n; j += i) {
					arr[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = m; i <= n; i++) {
			if(!arr[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
	
}