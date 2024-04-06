import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>(n);
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			map.put(s[0], s[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			sb.append(map.get(s[0])).append("\n");
		}
		
		System.out.println(sb);
	}
	
}