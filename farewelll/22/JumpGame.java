package twentytwo;

public class JumpGame {
    public boolean canJump(int[] A) {
        // write your code here
        int len = 0;

        for (int i = 0; i < A.length - 1; i++) {
            len = Math.max(len - 1, A[i]);

            if (len <= 0) {
                return false;
            }
        }

        return true;
    }
}
