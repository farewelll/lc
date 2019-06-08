package twenty;

import java.util.Arrays;

public class TopkLargestNumbers {
    public int[] topk(int[] nums, int k) {
        // write your code here
        int[] arr = new int[k];
        Arrays.sort(nums);
        int index = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            arr[index] = nums[i];
            index++;
        }
        return arr;
    }
}
