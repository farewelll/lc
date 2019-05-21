package two;

import java.util.Arrays;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        return nums[0];
    }
}
