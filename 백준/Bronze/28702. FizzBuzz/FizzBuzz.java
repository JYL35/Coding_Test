import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int num = 0;
        if(!a.contains("zz")) num = Integer.parseInt(a) + 3;
        else if(!b.contains("zz")) num = Integer.parseInt(b) + 2;
        else num = Integer.parseInt(c) + 1;

        String result = "" + num;
        if(num % 3 == 0 && num % 5 == 0) result = "FizzBuzz";
        else if(num % 3 == 0) result = "Fizz";
        else if(num % 5 == 0) result = "Buzz";

        System.out.println(result);
    }
}