class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) list.add(interval);

        int pos = search(list, newInterval);
        if(pos == list.size())
            list.add(newInterval);
        else
            list.add(pos, newInterval);
        
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            if(ans.size() == 0) {
                ans.add(list.get(i));
            }else{
                int[] last = ans.get(ans.size()-1);
                if(last[1] >= list.get(i)[0]){
                    last[1] = Math.max(last[1], list.get(i)[1]);
                }else{
                    ans.add(list.get(i));
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    private int search(List<int[]> list, int[] newInterval) {
        int l = 0, r = list.size();
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(list.get(mid)[0] > newInterval[0]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}