import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[201][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String[] sp = s.split(" ");
			int j = 0;
			while (arr[Integer.parseInt(sp[0])][j] != null) j++;
			arr[Integer.parseInt(sp[0])][j] = s;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; arr[i][j] != null; j++) System.out.println(arr[i][j]);
		}
	}
	
}