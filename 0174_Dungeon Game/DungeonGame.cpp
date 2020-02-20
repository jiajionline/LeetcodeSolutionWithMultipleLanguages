class Solution {
public:
  int calculateMinimumHP(vector<vector<int>>& dungeon) {      
    const int m = dungeon.size();
    const int n = dungeon[0].size();
 
    // hp[y][x]: min hp required to reach bottom right (P).
    vector<int> hp(n + 1, INT_MAX);
    hp[n - 1] = 1;
 
    for (int y = m - 1; y >= 0; --y)
      for (int x = n - 1; x >= 0; --x)
        hp[x] = max(1, min(hp[x], hp[x + 1]) - dungeon[y][x]);
 
    return hp[0];
  }
};