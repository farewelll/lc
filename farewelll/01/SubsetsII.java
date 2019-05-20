import java.util.*;

public class SubsetsII {
    List<List<Integer>> data = new ArrayList<>();
    int length;
    int dataNumarr[];
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        length = nums.length;
        dataNumarr = nums;
        Arrays.sort(nums);
        List<Integer> combination= new ArrayList<>();
        getCombination(combination, 0);
        return data;

    }
    public void getCombination(List<Integer> combination, int index){
        data.add(combination);
        for(int i = index; i < length; i++){
            List<Integer> sub1= new ArrayList<>(combination);
            sub1.add(dataNumarr[i]);
            if(i != index && dataNumarr[i] == dataNumarr[i - 1] ){
                continue;
            }
            getCombination(sub1, i + 1);
        }
    }
}
