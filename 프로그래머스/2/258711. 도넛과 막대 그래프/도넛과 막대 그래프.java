import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> graph = new HashMap<>();
    	int[] answer = new int[4];
    	int[] countArr;
    	
    	Arrays.stream(edges).forEach(edge -> {
    		int a = edge[0];
    		int b = edge[1];
    		if(!graph.containsKey(a)) {
    			graph.put(a, new int[] {0, 0});
    		}
    		if(!graph.containsKey(b)) {
    			graph.put(b, new int[] {0, 0});
    		}
    		graph.get(a)[0] += 1;
    		graph.get(b)[1] += 1;
    	});
    	
    	int outEdge = 0;
    	for (int key : graph.keySet()) {
    		countArr = graph.get(key);
    		
    		if(countArr[0] >= 2 && countArr[1] == 0) {
    			answer[0] = key;
    			outEdge = countArr[0];
    		}
    		else if(countArr[0] == 0 && countArr[1] >= 1) answer[2]++;
    		else if(countArr[0] >= 2 && countArr[1] >= 2) answer[3]++;
    	}
    	answer[1] = outEdge - answer[2] - answer[3];
    	
        return answer;
    }
}