package four;

public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return new int[]{-1 ,-1};
        }
        if (A.length == 1){
            return new int[]{0 ,0};
        }
        int [] range = new int[2];
        int max = A.length - 1;
        int min = 0;
        int cur = 0;
        while (min + 1 < max) {
            cur = min + (max - min) / 2;
            if (A[cur] == target)
                max = cur;
            else if (A[cur] < target){
                min = cur + 1;
            } else {
                max = cur -1;
            }
        }
        if (A[min] == target){
            cur = max;
        }else if (A[max] == target){
            cur = max;
        } else {
            return new int[]{-1 ,-1};
        }
        int left = cur,right = cur;
        for (int i = cur + 1 ; i < A.length ; i ++){
            if (A[cur] == A[i]){
                right++;
            } else {
                break;
            }
        }
        for (int i = cur - 1 ; i >= 0 ; i --){
            if (A[cur] == A[i]){
                left--;
            } else {
                break;
            }
        }
        return new int[]{left,right};
    }
}
