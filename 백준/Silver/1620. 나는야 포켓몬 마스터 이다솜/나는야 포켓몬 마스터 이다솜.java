import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map1 = new HashMap<>(n);
		HashMap<String, Integer> map2 = new HashMap<>(n);
		
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			map1.put(i, s);
			map2.put(s, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= m; i++) {
			String s = br.readLine();
			if(s.charAt(0) > 64) {
				sb.append(map2.get(s)).append("\n");
			}
			else {
				sb.append(map1.get(Integer.parseInt(s))).append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
}