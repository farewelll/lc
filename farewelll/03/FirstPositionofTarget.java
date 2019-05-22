package three;

public class FirstPositionofTarget {
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums.length == 0 || nums == null){
            return -1;
        }
        int min = 0, max = nums.length - 1;
        while (min + 1 < max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target)
                max = mid;
            else if (nums[mid] < target){
                min = mid + 1;
            } else {
                max = mid -1;
            }
        }
        if (nums[min] == target){
            return min;
        }
        if (nums[max] == target){
            return max;
        }
        return -1;
    }
}
