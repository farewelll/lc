package thirteen;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]),nums[i]);
            min = Math.min(Math.min(min * nums[i],tmp * nums[i]),nums[i]);
            sum = Math.max(sum,max);
        }
        return sum;
    }
}
