/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    
    private Deque<NestedInteger> deque = new ArrayDeque();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger ni : nestedList)
            deque.addLast(ni);
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            Integer i = deque.pollFirst().getInteger();   
            return i;
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        while(deque.size() > 0 && !deque.peekFirst().isInteger()) {
            List<NestedInteger> niList = deque.pollFirst().getList();
            for(int i=niList.size()-1;i>=0;i--)
                deque.addFirst(niList.get(i));
        }
        
        return deque.size() > 0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */