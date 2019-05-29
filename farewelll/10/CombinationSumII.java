package ten;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> data;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        data = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(candidates);
        cal(candidates, target, 0, tmp);
        return data;
    }

    private void cal(int[] nums, int target, int index, List<Integer> tmp){
        if(target < 0){
            return;
        } else if(target == 0){
            List<Integer> jieguo = new LinkedList<Integer>(tmp);
            data.add(jieguo);
        } else {
            for(int i = index; i < nums.length; i++){
                tmp.add(nums[i]);
                cal(nums, target - nums[i], i+1, tmp);
                tmp.remove(tmp.size() - 1);
                while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
    }
}
