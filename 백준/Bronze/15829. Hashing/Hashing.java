import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int m = 1234567891;
		String h = sc.next();
		
		long sum = 0;
		long pow = 1;
		for(int i = 0; i < l; i++) {
			sum += ((h.charAt(i) - 96) * pow);
			pow = pow * 31 % m;
		}
		System.out.println(sum % m);
	}
}