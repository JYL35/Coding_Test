import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();

		if (str.isEmpty() != true) {
			String[] str2 = str.split(" ");
			System.out.println(str2.length);
		}
		else System.out.println(0);
	}
}