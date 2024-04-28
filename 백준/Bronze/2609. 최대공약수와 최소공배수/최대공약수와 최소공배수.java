import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int large = (a >= b) ? a : b;
		int small = (a < b) ? a : b;
		
		while (true) {
			int remainder = large % small;
			if (remainder == 0) {
				System.out.println(small);
				System.out.println(a * b / small);
				break;
			}
			else {
				large = small;
				small = remainder;
			}
		}
	}
}