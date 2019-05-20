public class mplementstrStr {
    public int strStr(String source, String target) {
        // Write your code here
        if (target.equals("")){
            return 0;
        } else if (source.equals(target)){
            return 0;
        }else {
            int length = target.length();
            for (int i = 0 ; i <= source.length() - length ; i ++){
                if (source.charAt(i) == target.charAt(0)){
                    String judge = source.substring(i , i + length);
                    if (judge.equals(target)){
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
