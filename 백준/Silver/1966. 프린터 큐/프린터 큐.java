import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < testCase; i++) {
			Queue<Integer> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int index = n;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
			}
			
			int result = 0;
			int max = 9;
			while(!queue.isEmpty()) {
				int num = queue.peek();
				
				while(!queue.contains(max)) max--;
				
				if(num == max) {
					queue.remove();
					result++;
					if (index == 0) break;
					index--;
				}
				else if(num != max) {
					queue.add(queue.remove());
					if(index == 0) index = queue.size();
					index--;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
}