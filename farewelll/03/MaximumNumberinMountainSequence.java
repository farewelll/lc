package three;

public class MaximumNumberinMountainSequence {
    public int mountainSequence(int[] nums) {
        // write your code here
        int max = nums[0];
        for (int i = 0 ; i < nums.length - 1 ; i ++){
            if (nums[i] > nums [i + 1]){
                max = nums[i];
                break;
            }
        }
        return max;
    }
}
