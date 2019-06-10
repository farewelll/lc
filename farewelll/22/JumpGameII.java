package twentytwo;

public class JumpGameII {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = 0 ;
        int jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int fartest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > fartest) {
                    fartest = A[i] + i;
                }
            }
            start = end + 1;
            end = fartest;
        }
        return jumps;
    }
}
