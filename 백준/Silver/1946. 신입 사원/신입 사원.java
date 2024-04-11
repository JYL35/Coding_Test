import java.io.*;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int[] arr;
	
	
	private static int selectPeople() {
		int count = 1, min = 1;
		
		for (int i = 2; i <= n; i++) {
			if(arr[min] > arr[i]) {
				count++;
				min = i;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a] = b;
			}
			sb.append(selectPeople()).append("\n");
		}
		System.out.println(sb);
	}
	
}