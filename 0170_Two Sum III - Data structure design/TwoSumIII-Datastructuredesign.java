class TwoSum {
    private List<Integer> list;

    public TwoSum() {
        list = new ArrayList<Integer>();
    }
    
    public void add(int number) {
        int i = list.size()-1;
        for(;i>=0;i--) {
            if(list.get(i) <= number) break;
        }
        
        if(i == list.size()) 
            list.add(number);
        else
            list.add(i+1, number);
    }
    
    public boolean find(int value) {
        int l = 0, r = list.size() - 1;
        while(l < r) {
            int v = list.get(l) + list.get(r);
            if(v == value) return true;
            else if(v < value)
                l++;
            else 
                r--;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */