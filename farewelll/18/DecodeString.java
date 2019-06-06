package eighteen;

import java.util.Stack;

public class DecodeString {
    public String expressionExpand(String s) {
        // write your code here
        if (s.length() == 0) {
            return "";
        }

        Stack<Integer> numzhan = new Stack<>();
        Stack<String> strzhan = new Stack<>();
        String data = "";

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + s.charAt(i) - '0';
                    i++;
                }
                numzhan.push(count);
            } else if (s.charAt(i) == '[') {
                strzhan.push(data);
                data = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(strzhan.pop());
                int repeatTime = numzhan.pop();

                for (int index = 0; index < repeatTime; index++) {
                    sb.append(data);
                }
                data = sb.toString();
                i++;
            } else {
                data += s.charAt(i);
                i++;
            }
        }
        return data;
    }
}
