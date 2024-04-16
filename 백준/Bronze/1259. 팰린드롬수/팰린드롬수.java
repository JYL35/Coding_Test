import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			boolean tf = false;
			String s = sc.next();
			if (s.equals("0")) break;
			tf = true;
			int half = s.length() / 2;
			int end = s.length() - 1;
			for(int i = 0; i < half; i++) {
				if (s.charAt(i) != s.charAt(end)) {
					tf = false;
					break;
				}
				end--;
			}
			String yn = tf ? "yes" : "no";
			System.out.println(yn);
		}
	}
}