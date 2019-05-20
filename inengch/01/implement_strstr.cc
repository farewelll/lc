class Solution {
public:
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    int strStr(string &source, string &target) {
        // Write your code here
        if (target.empty()) {
            return 0;
        }
        if (source.empty() && !target.empty()) {
            return -1;
        }
        if (source.size() < target.size()) {
            return -1;
        }
        int j;
        for (int i = 0; i < source.size() - target.size() + 1; ++i) {
            for (j = 0; j < target.size(); ++j) {
                if (source[i + j] != target[j]) {
                    break;
                }
            }
            if (j == target.size()) {
                return i;
            }
        }
        return -1;
    }
};
