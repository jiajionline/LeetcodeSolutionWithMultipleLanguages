class MovingAverage {
    private long _sum;
    private int _size;
    private Queue<Integer> _q;
    public MovingAverage(int size) {
        _size = size;
        _q = new LinkedList<Integer>();
        _sum = 0;
    }
    
    public double next(int val) {
        _sum += val;
        if(_q.size() == _size)
        {
            _sum -= _q.poll();
        }
        
        _q.add(val);
        
        return _sum / (double)_q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */