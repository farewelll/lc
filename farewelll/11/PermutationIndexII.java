package eleven;

import java.util.HashMap;

public class PermutationIndexII {
    public long permutationIndexII(int[] A) {
        long index = 0, factor = 1, position = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = A.length-1; i >= 0; i--) {
            if (!map.containsKey(A[i])) map.put(A[i], 1);
            else {
                map.put(A[i], map.get(A[i])+1);
                position *= map.get(A[i]);
            }
            int da = 0;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[i]){
                    da++;
                }
            }
            index =  index + da * factor / position;
            factor *= (A.length - i);
        }
        return index+1;
    }

}
