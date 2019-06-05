package seventeen;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int []data = new int[2];
        if (numbers.length == 0 || numbers == null){
            return data;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < numbers.length ; i ++){
            if (map.get(numbers[i]) != null){
                data[0] = map.get(numbers[i]);
                data[1] = i;
                break;
            }
            map.put(target - numbers[i] , i);
        }
        return data;
    }
}
