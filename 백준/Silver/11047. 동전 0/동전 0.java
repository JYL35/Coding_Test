import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	private static int count(int[] arr, int n, int k) {
		int result = 0;
		
		while(k != 0) {
			int max = n - 1;
			for (int i = 0; i < n; i++) {
				if(arr[i] > k) {
					max = i - 1;
					break;
				}
			}
			result += k / arr[max];
			k %= arr[max];
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(count(arr, n, k));;
		
	}
	
}