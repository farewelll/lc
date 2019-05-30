package eleven;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int maxLength = s.length();
        if (getDictLength(dict) < maxLength){
            maxLength = getDictLength(dict);
        }
        boolean[] currentWetherOK = new boolean[s.length() + 1];
        currentWetherOK[0] = true;
        for(int i = 1; i < currentWetherOK.length; i++){
            for(int j = 1; j <= maxLength && j <= i; j++){
                String str = s.substring(i - j,i);
                if(dict.contains(str) && currentWetherOK[i - j]){
                    currentWetherOK[i] = true;
                    break;
                }
            }
        }

        return currentWetherOK[currentWetherOK.length - 1];
    }

    private int getDictLength(Set<String> dict){
        int max = 0;
        for(String s : dict){
            max = Math.max(max,s.length());
        }
        return max;
    }
}
