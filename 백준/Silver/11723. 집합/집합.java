import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList();
		
		
		
		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			
			
			switch (str[0]) {
				case "add":
					if(!queue.contains(Integer.parseInt(str[1]))) queue.add(Integer.parseInt(str[1]));
					break;
				case "remove":
					if(queue.contains(Integer.parseInt(str[1]))) queue.remove(Integer.parseInt(str[1]));
					break;
				case "check":
					if(queue.contains(Integer.parseInt(str[1]))) sb.append("1\n");
					else sb.append("0\n");
					break;
				case "toggle":
					if(queue.contains(Integer.parseInt(str[1]))) queue.remove(Integer.parseInt(str[1]));
					else queue.add(Integer.parseInt(str[1]));
					break;
				case "all":
					queue.clear();
					for (int j = 1; j <= 20; j++) {
						queue.add(j);
					}
					break;
				case "empty":
					Queue<Integer> temp = new LinkedList();
					queue = temp;
					break;
			}
		}
		System.out.println(sb);

	}

}