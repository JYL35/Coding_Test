import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int result = 666;
		int count = 0;
		
		for (int i = result;; i++) {
			String s = "" + i;
			if(s.contains("666")) {
				count++;
				result = i;
				if (n == count) break;
			}
		}
		
		System.out.println(result);
	}
	
}