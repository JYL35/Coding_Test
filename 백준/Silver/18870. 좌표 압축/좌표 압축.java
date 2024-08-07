import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int orderNum = 0;
        for (int i = 0; i < n; i++) {
            if(map.get(temp[i]) == null)map.put(temp[i], orderNum++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.println(sb);
    }
}