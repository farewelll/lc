package three;

public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        // write your code here
        int min = 1, max = n;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (!SVNRepo.isBadVersion(mid))
                min = mid + 1;
            else max = mid;
        }
        return min;
    }
}
