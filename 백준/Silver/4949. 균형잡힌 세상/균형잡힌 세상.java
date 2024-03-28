import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if (s.equals(".")) break;
			boolean tf = false;
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if(c == '.') {
					if(stack.isEmpty()) tf = true;
					else tf = false;
					break;
				}
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
						tf = true;
					}
					else {
						tf = false;
						break;
					}
				}
				else if(c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
						tf = true;
					}
					else {
						tf = false;
						break;
					}
				}
			}
			if(tf) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
			
		}
		System.out.println(sb);
		
	}

}
