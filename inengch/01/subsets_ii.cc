class Solution {
public:
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    void helper(const vector<int>& nums, vector<int>& tmp, int pos, vector<vector<int>>& res) {
        res.push_back(tmp);
        for (int i = pos; i < nums.size(); ++i) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.push_back(nums[i]);
            helper(nums, tmp, i + 1, res);
            tmp.pop_back();
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int> &nums) {
        // write your code here
        vector<vector<int>> res;
        if (nums.empty()) {
            return {{}};
        }
        sort(nums.begin(), nums.end());
        vector<int> tmp;
        helper(nums, tmp, 0, res);
        return res;
    }
};
