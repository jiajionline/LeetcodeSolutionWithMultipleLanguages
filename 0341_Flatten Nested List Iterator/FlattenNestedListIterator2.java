public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque  = new ArrayDeque<NestedInteger>();
        for(NestedInteger ni : nestedList) deque.add(ni);
    }

    @Override
    public Integer next() {
        return deque.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        flatten();
        return deque.size() > 0;
    }
    
    private void flatten() {
        if(deque.size() == 0) return;
        if(deque.peekFirst().isInteger()) return;
        List<NestedInteger> list = deque.pollFirst().getList();
        for(int i=list.size() - 1;i>=0;i--) {
            deque.addFirst(list.get(i));
        }
        flatten();
    }
}