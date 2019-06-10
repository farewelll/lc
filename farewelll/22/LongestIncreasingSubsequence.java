package twentytwo;

public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        int []arr = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    arr[i] = arr[i] > arr[j] + 1 ? arr[i] : arr[j] + 1;
                }
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
