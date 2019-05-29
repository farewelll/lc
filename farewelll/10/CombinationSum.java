package ten;

import java.util.*;

public class CombinationSum {
    // 暴力去重。。。
    Set<List<Integer>> data = new  HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(candidates);
        cal(candidates, target, 0, tmp);
        return new ArrayList<>(data);
    }

    private void cal(int[] nums, int target, int index, List<Integer> tmp){
        if(target < 0){
            // 总和大了，算错啦！
            return;
        } else if(target == 0){
            // 相等返回生成的 list ，得到一个结果！
            List<Integer> jieguo = new ArrayList<>(tmp);
            data.add(jieguo);
        } else {
            for(int i = index; i < nums.length; i++){
                // 递归的调用，每回加一个数，目标数减少。
                tmp.add(nums[i]);
                cal(nums, target - nums[i], i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
