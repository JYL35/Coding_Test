import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                if(map.containsKey(s[1])){
                    map.replace(s[1], map.get(s[1]) + 1);
                }
                else{
                    map.put(s[1], 2);
                }
            }
            int count = 1;

            for (int j : map.values()){
                count *= j;
            }
            sb.append(count - 1).append("\n");
        }
        System.out.println(sb);
    }
}