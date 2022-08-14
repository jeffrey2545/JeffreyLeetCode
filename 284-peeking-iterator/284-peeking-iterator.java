// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    while (iterator.hasNext()) {
            queue.offer(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return queue.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return queue.poll();
	}
	
	@Override
	public boolean hasNext() {
        if (queue.size() == 0) {
            return false;
        } else {
            return true;
        }
	}
}