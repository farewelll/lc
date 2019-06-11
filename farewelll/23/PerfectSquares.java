package twentythree;

public class PerfectSquares {
    public int numSquares(int n) {
        // write your code here
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (arr [i] > arr [i - j * j ] + 1) {
                    arr[i] = arr[i - j * j] + 1;
                }
            }
        }
        return arr[n];
    }
}
