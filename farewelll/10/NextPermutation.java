package ten;

public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int index = nums.length - 1;
        while (index > 0){
            if (nums[index] > nums[index - 1])
                break;
            else index --;
        }
        int l = nums.length - 1;
        if (index > 0) {
            while (nums[index - 1] >= nums[l]) {
                l--;
            }
            swap(nums, index - 1, l)   ;
        }
        reverse(nums, index, nums.length - 1);
        return nums;
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private void reverse(int[] array, int begin, int end) {
        while (begin < end) {
            swap(array, begin, end);
            begin++;
            end--;
        }
    }
}
