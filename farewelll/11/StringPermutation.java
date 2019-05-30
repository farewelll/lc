package eleven;

import java.util.Arrays;

public class StringPermutation {
    public boolean Permutation(String A, String B) {
        // write your code here
        if (A.equals(B)){
            return true;
        }
        if (A == null || B == null || A.length() == 0 || B.length() == 0){
            return false;
        }
        char []a = A.toCharArray();
        char []b = B.toCharArray();
        boolean flag = true;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0 ; i < a.length ;i ++){
            if (a[i] != b[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
