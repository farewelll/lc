package fifteen;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        Set<List<Integer>> set = new HashSet<>();
        if (numbers == null || numbers.length < 3){
            return new ArrayList<>(set);
        }
        int sum;
        Arrays.sort(numbers);
        for (int i  = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                for (int k = j + 1; k < numbers.length; k++){
                    sum = numbers[i] + numbers[j] + numbers[k];
                    if (sum == 0){
                        List<Integer> myList = new ArrayList<>();
                        myList.add(numbers[i]);
                        myList.add(numbers[j]);
                        myList.add(numbers[k]);
                        set.add(myList);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
