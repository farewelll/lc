package twentytwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length;
        int max = 0;
        int maxindex = -1;
        int[] dp = new int[n];
        int[] index = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(index, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <  i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    index[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxindex = i;
            }
        }

        for (int i = maxindex; i >=0; ) {
            result.add(nums[i]);
            i = index[i];
        }

        return result;
    }
}
