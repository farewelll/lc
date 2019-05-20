class Solution {
public:
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    void helper(const vector<int>& nums, vector<int>& tmp, vector<int>& visited, vector<vector<int>>& res) {
        if (tmp.size() == nums.size()) {
            res.push_back(tmp);
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            if (visited[i] == 0) {
                visited[i] = 1;
                tmp.push_back(nums[i]);
                helper(nums, tmp, visited, res);
                tmp.pop_back();
                visited[i] = 0;
            }
        }
    }
    vector<vector<int>> permuteUnique(vector<int> &nums) {
        // write your code here
        vector<vector<int>> res;
        if (nums.empty()) {
            return {{}};
        }
        sort(nums.begin(), nums.end());
        vector<int> tmp;
        vector<int> visited(nums.size(), 0);
        helper(nums, tmp, visited, res);
        return res;
    }
};
