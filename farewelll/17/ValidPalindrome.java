package seventeen;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // write your code here
        String str = s.replaceAll("[^0-9A-Za-z]" , "");
        String finalStr = str.toLowerCase();
        int start = 0 ;
        int end = finalStr.length() - 1;
        while (start < end){
            if (finalStr.charAt(start) == finalStr.charAt(end)){
                start ++;
                end --;
            }else return false;
        }
        return true;
    }
}
