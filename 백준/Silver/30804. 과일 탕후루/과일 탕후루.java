import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, kindFruit;

    private static int twoPointer(int left, int right, int cnt, int kind, int max) {
        if(right == n) return max;

        if(kindFruit[arr[right]] == 0) kind++;

        kindFruit[arr[right]]++;
        cnt++;

        if(kind > 2) {
            kindFruit[arr[left]]--;
            cnt--;
            if(kindFruit[arr[left]] == 0) kind--;
            left++;
        }

        max = Math.max(max, cnt);

        return twoPointer(left, right+1, cnt, kind, max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        kindFruit = new int[10];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer(0, 0, 0, 0, 0));
    }

}