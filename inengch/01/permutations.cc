class Solution {
public:
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    void helper(const vector<int>& nums, vector<int>& tmp, vector<int>& visited, vector<vector<int>>& res) {
        if (tmp.size() == nums.size()) {
            res.push_back(tmp);
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (visited[i] == 0) {
                visited[i] = 1;
                tmp.push_back(nums[i]);
                helper(nums, tmp, visited, res);
                tmp.pop_back();
                visited[i] = 0;
            }
        }
    }
    vector<vector<int>> permute(vector<int> &nums) {
        // write your code here
        vector<vector<int>> res;
        if (nums.empty()) {
            return {{}};
        }
        vector<int> tmp;
        vector<int> visited(nums.size(), 0);
        helper(nums, tmp, visited, res);
        return res;
    }
};
