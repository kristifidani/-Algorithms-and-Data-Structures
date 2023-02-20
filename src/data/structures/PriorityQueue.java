package data.structures;

/**
 * Class representing a Priority Queue data structure implemented with
 * LinkedList
 * 
 * @author Kristi
 *
 */
public class PriorityQueue {
	private class PriorityPair implements Comparable {
		private Object element;
		private Object priority;

		/**
		 * @param element
		 * @param priority
		 */
		public PriorityPair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}

		/**
		 * @return
		 */
		public Object getElement() {
			return element;
		}

		public String toString() {
			return element.toString();
		}
	}

	private LinkedList data;
	private int size;

	public PriorityQueue() {
		data = new LinkedList();
		size = 0;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param o
	 * @param priority
	 */
	public void push(Object o, int priority) {
		PriorityPair p = new PriorityPair(o, priority);
		data.addSorted(p);
		size++;
	}

	/**
	 * @return
	 */
	public Object pop() {
		PriorityPair p = (PriorityPair) data.getFirst();
		data.removeFirst();
		size--;
		return p.getElement();
	}

	/**
	 * @return
	 */
	public Object top() {
		return data.getFirst();
	}
}
