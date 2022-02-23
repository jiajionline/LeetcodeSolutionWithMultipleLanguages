// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> _iter;
    private boolean _peeked = false;
    private Integer _curr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    _iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(_peeked) return _curr;
        else if(_iter.hasNext()) {
            _curr = _iter.next();
            _peeked = true;
            return _curr;
        }else{
            return null;
        }
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(_peeked) {
            _peeked = false;
            return _curr;
        }else if(_iter.hasNext()) return _iter.next();
        return null;
	}
	
	@Override
	public boolean hasNext() {
        if(_peeked) return true;
	    return _iter.hasNext();
	}
}