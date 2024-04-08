class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int indexOfSandwich = 0;
        Queue<Integer> studentQueue = new LinkedList<>();
        for(int v : students) studentQueue.add(v);

        int cntOfScan = 0;
        while(studentQueue.size() > 0 && cntOfScan < studentQueue.size()) {
            if(studentQueue.peek() == sandwiches[indexOfSandwich]) {
                indexOfSandwich++;
                studentQueue.poll();
                cntOfScan = 0;
            }else{
                cntOfScan++;
                studentQueue.add(studentQueue.poll());
            }
        }

        return studentQueue.size();
        
    }
}