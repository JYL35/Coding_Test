import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = new int[26];
		String s = scan.nextLine();
		
		for (int i = 0; i < s.length(); i++) {
			if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
				arr[s.charAt(i) - 65]++;
			}
			else {
				arr[s.charAt(i) - 97]++;
			}
		}
		
		int max = 0;
		char c = '?';
		
		for (int j = 0; j < 26; j++) {
			if (arr[j] > max) {
				max = arr[j];
				c = (char) (j + 65);
			}
			else if(arr[j] == max) {
				c = '?';
			}
		}
		System.out.println(c);
	}

}