public class strStrII {

    static final int ASCII_SIZE = 126;
    public int strStr2(String source, String target){
        if (source == null|| target == null){
            return  -1;
        } else if (source.equals(target) || target == ""){
            return 0;
        } else {
            return sunday(source.toCharArray() ,target.toCharArray());
        }

    }
    int sunday(char[] total,char[] part){
        int tSize = total.length;
        int pSize = part.length;
        int[] move = new int[ASCII_SIZE];
        for (int i= 0;i<ASCII_SIZE;i++){
            move[i] = pSize+1;
        }
        for (int i = 0;i<pSize;i++){
            move[part[i]] = pSize-i;
        }
        int s = 0;
        int j;
        while(s<=tSize-pSize){
            j = 0;
            while(total[s+j]==part[j]){
                j++;
                if (j>=pSize){
                    return s;
                }
            }
            s+=move[total[s+pSize]];
        }
        return -1;
    }
}
