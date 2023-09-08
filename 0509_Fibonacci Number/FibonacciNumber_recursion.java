class Solution {
    public int fib(int n) {
        return fib(n, new HashMap<Integer,Integer>());
    }

    private int fib(int n, Map<Integer,Integer> map) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(map.containsKey(n)) return map.get(n);
        int v = fib(n-1, map) + fib(n-2, map);
        map.put(n, v);
        return v;
    }
}