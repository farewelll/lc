// https://www.lintcode.com/problem/strstr-ii/description
public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return -1;
        final long BASE = 27;
        long tHash = 0, sHash = 0;
        long powerT = 1;
        for (int i = 0; i < t.length(); i++) {
          powerT = i > 0 ? powerT * BASE : 1;
          tHash = tHash * BASE + t.charAt(i) - 'a';
          sHash = sHash  * BASE + s.charAt(i) - 'a';
        }

        for (int i = t.length(); i < s.length(); i++) {
          if (tHash == sHash) {
            return i - t.length();
          }

          sHash -= (s.charAt(i - t.length()) - 'a') * powerT;
          sHash = sHash * BASE + s.charAt(i) - 'a';
        }

        if (tHash == sHash) {
          return s.length() - t.length();
        }
        return -1;
    }
}
