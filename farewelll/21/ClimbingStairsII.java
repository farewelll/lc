package twentyone;

public class ClimbingStairsII {
    public int climbStairs2(int n) {
        // write your code here
        if (n ==0){
            return 1;
        }
        if (n <= 2){
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int []arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3 ; i < n ; i ++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[n -1];
    }
}
