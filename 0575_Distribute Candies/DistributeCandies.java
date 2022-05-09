class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candyTypeSet = new HashSet<>();
        for(var ct : candyType) candyTypeSet.add(ct);
        
        return Math.min(candyTypeSet.size(),  candyType.length/ 2);
    }
}