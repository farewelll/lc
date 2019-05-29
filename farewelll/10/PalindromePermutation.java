package ten;

import java.util.BitSet;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        // write your code here
        BitSet bs = new BitSet();
        for (byte b : s.getBytes()) {
            bs.flip (b);
        }
        if (bs.cardinality() < 2){
            return true;
        } else {
            return false;
        }
    }
}
