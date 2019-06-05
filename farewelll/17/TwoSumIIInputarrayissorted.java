package seventeen;

import java.util.HashMap;

public class TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int []data = new int[2];
        if (nums.length == 0 || nums == null){
            return data;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i ++){
            if (map.get(nums[i]) != null){
                data[0] = map.get(nums[i]);
                data[1] = i;
                break;
            }
            map.put(target - nums[i] , i);
        }
        return data;
    }
}
