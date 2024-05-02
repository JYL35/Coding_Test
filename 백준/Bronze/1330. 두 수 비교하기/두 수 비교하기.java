import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		String s = "==";
		
		if (a > b) s = ">";
		else if (a < b) s = "<";
		else s = "==";
		System.out.println(s);
	}

}
