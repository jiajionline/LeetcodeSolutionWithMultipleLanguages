// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> _iter;
    private Deque<Integer> _buffer;
    private static final int BuffSize = 5;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    _iter = iterator;
        _buffer = new LinkedList<Integer>();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(hasNext()) {
            return _buffer.peekFirst();
        }
        
        return null;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasNext()) {
            return _buffer.pollFirst();
        }
        
        return null;
	}
	
	@Override
	public boolean hasNext() {
	    if(_buffer.size() > 0) return true;
        int buffIndex = 0;
        while(_iter.hasNext() && buffIndex < BuffSize) {
            _buffer.addLast(_iter.next());
            buffIndex++;
        }
        
        return _buffer.size() > 0;
	}
}