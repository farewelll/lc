package seventeen;

import java.util.Arrays;

public class TriangleCount {
    public int triangleCount(int[] S) {
        // write your code here
        if (S.length < 3){
            return 0;
        }
        int sum = 0;
        Arrays.sort(S);
        for (int i = 0 ; i < S.length - 2 ; i ++){
            for (int j = i + 1 ; j < S.length - 1 ; j ++){
                for (int k = j + 1 ; k < S.length ; k ++){
                    if (S[i] + S[j]> S[k]){
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }
}
