import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int currentListLength = list.size();
            for (int j = 0; j < currentListLength; j++) {
                List<Integer> addedList = new ArrayList<>();
                addedList.add(nums[i]);
                addedList.addAll(list.get(j));
                list.add(addedList);
            }
        }
        return list;
    }

}
