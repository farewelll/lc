package eighteen;

public class HashFunction {
    public int hashCode(char[] key,int HASH_SIZE) {
        long data = 0;
        for(int i = 0; i < key.length;i++) {
            data = (data * 33 + (int)(key[i])) % HASH_SIZE;
        }
        return (int)data;
    }
}
