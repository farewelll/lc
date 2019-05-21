package two;

public class ClassicalBinarySearch {
    public int findPosition(int[] nums, int target) {
        int min = 0;
        int max = nums.length -1  ;
        while (min <= max){
            int middle =  min+ (max - min) / 2;
            if(nums[middle] > target){
                max = middle - 1;
            }else if (nums[middle] < target){
                min = middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
