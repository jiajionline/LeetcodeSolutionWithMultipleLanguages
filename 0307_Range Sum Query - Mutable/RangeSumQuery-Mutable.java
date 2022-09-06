class NumArray {
    FenwickTree _tree;
    int[] _nums;
    public NumArray(int[] nums) {
        _nums = nums;
        _tree = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; ++i)
            _tree.update(i + 1, nums[i]);
    }
    
    public void update(int i, int val) {
        _tree.update(i + 1, val - _nums[i]);
        _nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return _tree.query(j + 1) - _tree.query(i);
    }
    
    class FenwickTree {
        int sums_[];
        public FenwickTree(int n) {
            sums_ = new int[n + 1];
        }
        
        public void update(int i, int delta) {
            while (i < sums_.length) {
                sums_[i] += delta;
                i += i & -i;
            }
        }
        
        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums_[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}