class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int l = 0;
        int r = n - k;
        List<Integer> ans = new ArrayList<Integer>();
        
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(x - arr[mid] > arr[mid + k ] - x)
                l = mid + 1;
            else
                r = mid ;
        }
        
        for(int i=l;i<l+k;i++)
            ans.add(arr[i]);
        
        return ans;
    }
}