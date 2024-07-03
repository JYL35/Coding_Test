import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] treeArr;

    private static int binarySearch(int lo, int hi) {
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if(treeArr[i] > mid) sum += treeArr[i] - mid;
            }

            if (sum >= m) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        treeArr = new int[n];

        int tallTree = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
            if(tallTree < treeArr[i]) tallTree = treeArr[i];
        }

        System.out.println(binarySearch(0, tallTree) - 1);
    }
}
