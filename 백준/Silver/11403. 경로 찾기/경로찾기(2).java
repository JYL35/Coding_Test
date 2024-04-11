import java.io.*;

public class Main {
	static int n;
	static boolean[] visit;
	static int[][] graph;
	
	private static void printMatrix() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(graph[i][j] == 1) {
					sb.append(1).append(" ");
					continue;
				}
				visit = new boolean[n];
				if(checkPath(i, j)) sb.append(1).append(" ");
				else sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean checkPath(int start, int end) {
		if(start == end && visit[end]) return true;
		
		for (int i = 0; i < n; i++) {
			if(graph[start][i] == 1 && !visit[i]) {
				visit[i] = true;
				if(checkPath(i, end)) return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				graph[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		printMatrix();
	}
	
}
