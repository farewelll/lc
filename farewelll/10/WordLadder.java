package ten;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Set<String> reached = new HashSet<>();
        reached.add(start);
        dict.add(end);
        int distance = 1;
        while(!reached.contains(end)) {
            Set<String> toAdd = new HashSet<>();
            for(String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(dict.contains(word)) {
                            toAdd.add(word);
                            dict.remove(word);
                        }
                    }
                }
            }
            distance ++;
            if(toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
}
