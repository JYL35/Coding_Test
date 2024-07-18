import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.MAX_VALUE;
        String[] temp = br.readLine().split("-");

        for (int i = 0; i < temp.length; i++) {
            int num = 0;
            String[] arr = temp[i].split("\\+");
            for (String str : arr) {
                num += Integer.parseInt(str);
            }
            if(result == Integer.MAX_VALUE) result = num;
            else result -= num;
        }
        System.out.println(result);
    }
}