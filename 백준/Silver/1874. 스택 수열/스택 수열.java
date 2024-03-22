import java.io.*;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int index = 0;
		for(int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append("+\n");
			while(!stack.isEmpty() && arr[index] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				index++;
			}
		}
		if(stack.isEmpty()) System.out.println(sb);
		else System.out.println("NO");
	}
	
}