import java.io.*;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int except = (int)Math.round(n * 0.15);
		
		for(int i = 0; i < n; i++) {
			arr[i] = (Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(arr);
		
		float sum = 0;
		int count = 0;
		for(int i = except; i < n - except; i++) {
			sum += arr[i];
			count++;
		}
		System.out.println((int)Math.round(sum / count));
	}
	
}