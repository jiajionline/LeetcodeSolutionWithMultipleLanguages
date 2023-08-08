// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> _iter;
	private Integer _val;
	public PeekingIterator(Iterator<Integer> iterator) {
	    _iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(hasNext()){
			return _val;
		}else{
			return null;
		}
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(hasNext()){
			Integer v = _val;
			_val = null;
			return v;
		}else{
			return null;
		}
	  
	}
	
	@Override
	public boolean hasNext() {
	  if(_val != null) return true;
		if(_iter.hasNext()) {
			_val = _iter.next();
			return true;
		}
		return false;
	}
}