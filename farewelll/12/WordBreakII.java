package twelve;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return dfs(map, s, wordDict);
    }

    private List<String> dfs(Map<String, List<String>> map,
                             String s, Set<String> wordDict) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> data = new ArrayList<>();
        if (wordDict.contains(s)) {
            data.add(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String current = s.substring(0, i);
            if (wordDict.contains(current)) {
                String remain = s.substring(i, s.length());
                for (String line : dfs(map, remain, wordDict)) {
                    data.add(current + " " + line);
                }
            }
        }
        map.put(s, data);
        return data;
    }

}
