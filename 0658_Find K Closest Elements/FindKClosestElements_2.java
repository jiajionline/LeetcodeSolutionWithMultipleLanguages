class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int n = arr.length;
        // Base case
        if (n == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            
            return result;
        }
        
        // Binary search to find the first element >= x
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        l -= 1;
        r = l + 1;
        
        while (r - l - 1 < k) {
            if (l == -1)
                r++;
            else if(r == n) 
                l--;
            else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x))
                l--;
            else 
                r++;
        } 

        // Build and return the window
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}