class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int[] splitArr = new int[j-i+1];
            
            for(int y = 0; y < j-i+1; y++) {
                splitArr[y] = array[y+i-1];
            }
            
            for(int y = 0; y < j-i+1; y++) {
                int min = y;
                for(int z = y+1; z < j-i+1; z++) {
                    if(splitArr[min] > splitArr[z]) min = z;
                }
                int temp = splitArr[min];
                splitArr[min] = splitArr[y];
                splitArr[y] = temp;
            }
            
            answer[x] = splitArr[k-1];
        }
        
        return answer;
    }
}