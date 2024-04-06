import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += arr[j];
			}
			result += sum;
		}
		
		System.out.println(result);
		
	}
	
}