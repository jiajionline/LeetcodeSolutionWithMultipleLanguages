class FenwickTree {
    private int _sums[];
    public FenwickTree(int n) {
        _sums = new int[n + 1];
    }
    
    public void update(int i, int delta) {
        while (i < _sums.length) {
            _sums[i] += delta;
            i += lowbit(i);
        }
    }
    
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += _sums[i];
            i -= lowbit(i);
        }
        return sum;
    }

    private int lowbit(int x) {
        return x & (-x);
    }
}