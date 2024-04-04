import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr);
		
		String[] resultArr = new String[m];
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if(Arrays.binarySearch(arr, s) >= 0) {
				cnt++;
				resultArr[i] = s;
			}
			else resultArr[i] = "0";
		}
		Arrays.sort(resultArr);
		System.out.println(cnt);
		for(String str : resultArr) if(str != "0") System.out.println(str);
		
	}
	
}