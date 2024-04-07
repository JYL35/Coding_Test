import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	private static void sort(String[] arr, int n) {
		for (int i = n - 1; i >= 0; i--) {
			int max = 0;
			for (int j = 0; j <= i; j++) {
				if (arr[j].length() > arr[max].length()) max = j;
				else if (arr[j].length() == arr[max].length()) {
					for (int k = 0; k < arr[j].length(); k++) {
						if (arr[j].charAt(k) > arr[max].charAt(k)) {
							max = j;
							break;
						}
						else if (arr[j].charAt(k) < arr[max].charAt(k)) break;
					}
				}
			}
			swap(arr, max, i);
		}
	}
	
	private static void swap(String[] arr, int max, int last) {
		String temp = arr[last];
		arr[last] = arr[max];
		arr[max] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			boolean tf = true;
			for (int j = 0; j < i; j++) {
				if (arr[j].equals(s)) {
					tf = false;
					break;
				}
			}
			if (tf) arr[i] = s;
			else {
				i--;
				n--;
			}
		}
		
		sort(arr, n);
		
		for (String s : arr) {
			if (s == null) continue;
			System.out.println(s);
		}
	}
	
}