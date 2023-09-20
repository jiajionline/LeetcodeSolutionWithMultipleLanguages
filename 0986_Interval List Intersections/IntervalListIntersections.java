class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int index1 = 0, index2 = 0;
        List<int[]> list = new ArrayList<>();
        while(index1 < firstList.length && index2 < secondList.length) {
            if(Math.max(firstList[index1][0], secondList[index2][0]) <= Math.min(firstList[index1][1], secondList[index2][1])){
                list.add(new int[]{Math.max(firstList[index1][0], secondList[index2][0]), Math.min(firstList[index1][1], secondList[index2][1])});
            }

            if(firstList[index1][1] <= secondList[index2][1]){
                index1++;
            }else{
                index2++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}