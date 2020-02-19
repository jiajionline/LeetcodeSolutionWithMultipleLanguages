class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans;
        
        // 2^9, generate all combinations of [1 .. 9]
        for (int i = 0; i < (1 << 9); ++i) {
            vector<int> cur;
            int sum = 0;
            // Use j if (j - 1)-th bit is 1
            for (int j = 1; j <= 9; ++j)
                if (i & (1 << (j - 1))) {
                    sum += j;
                    cur.push_back(j);
                }
            if (sum == n && cur.size() == k) 
                ans.push_back(cur);
        }
        
        return ans;
    }
};