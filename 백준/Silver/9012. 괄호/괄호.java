import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean tf = false;
			boolean YN = true;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					stack.add(s.charAt(j));
					tf = true;
				}
				else if(tf && !stack.isEmpty()){
					stack.pop();
				}
				else {
					YN = false;
					break;
				}	
			}
			if(YN && stack.isEmpty()) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}

}
