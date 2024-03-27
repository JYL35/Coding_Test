import java.io.*;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] tempArr = new int[8001];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		double sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			tempArr[arr[i] + 4000]++;
		}
		int avg = (int)Math.round(sum / n);
		int mid = arr[n / 2];
		int temp = 0, maxCnt = 0, maxIndex = 1;
		int range = arr[n - 1] - arr[0];
		
		for(int i = 0; i < 8001; i++) {
			if(i == 0 || tempArr[maxCnt] < tempArr[i]) {
				maxCnt = i;
				maxIndex = 1;
			}
			else if (tempArr[maxCnt] == tempArr[i]) {
				maxIndex++;
				if(maxIndex == 2) temp = i - 4000;
			}
		}
		if(maxIndex >= 2) maxCnt = temp;
		else maxCnt -= 4000;
		System.out.printf("%d\n%d\n%d\n%d", avg, mid, maxCnt, range);
	}
	
}