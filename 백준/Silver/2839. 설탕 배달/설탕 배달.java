import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int quot = n / 5;
		int remain = n % 5;
		
		while(quot >= 0) {
			int a = remain / 3;
			int b = remain % 3;
			if (b == 0) {
				answer = quot + a;
				break;
			}
			quot--;
			remain += 5;
		}
		
		if(answer == 0) System.out.println(-1);
		else System.out.println(answer);
	}

}