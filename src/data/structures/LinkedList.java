package data.structures;

/**
 * Class representing a LinkedList data structure
 * 
 * @author Kristi
 *
 */
public class LinkedList {
	private class ListElement {
		private Object el1;
		private ListElement el2;

		/**
		 * @param el
		 * @param nextElement
		 */
		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		/**
		 * @param el
		 */
		public ListElement(Object el) {
			this(el, null);
		}

		/**
		 * @return
		 */
		public Object first() {
			return el1;
		}

		/**
		 * @return
		 */
		public ListElement rest() {
			return el2;
		}

		/**
		 * @param value
		 */
		public void setRest(ListElement value) {
			el2 = value;
		}
	}

	private ListElement head, tail;
	private int count;

	public LinkedList() {
		head = null;
	}

	/**
	 * @param o
	 */
	public void addFirst(Object o) {
		head = new ListElement(o, head);
		count++;
		if (count == 1) {
			tail = head;
		}
	}

	/**
	 * @return
	 */
	public Object getFirst() {
		return head.first();
	}

	/**
	 * @param n
	 * @return
	 */
	public Object get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}

	public String toString() {
		String s = "";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += "";
		return s;
	}

	/**
	 * @return
	 */
	public int size() {
		ListElement temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.rest();
		}
		return count;
	}

	/**
	 * @param o
	 */
	public void addLast(Object o) {
		if (head == null) {
			head = new ListElement(o);
			return;
		}

		ListElement temp = head;
		while (temp.el2 != null) {
			temp = temp.el2;
		}

		temp.el2 = new ListElement(o);
	}

	/**
	 * @param o
	 */
	public void add(Object o) {
		if (size() == 0) {
			head = new ListElement(o);
		} else {
			ListElement newHead = new ListElement(o);
			newHead = head;
			head = newHead;
		}
	}

	public void removeFirst() {
		if (head == null) {
			return;
		} else {
			head = head.el2;
		}
		count--;
	}

	/**
	 * @return
	 */
	public Object getLast() {
		ListElement temp = head;
		while (temp.el2 != null) {
			temp = temp.el2;
		}
		return temp.first().toString();
	}

	/**
	 * used in the Priority Queue
	 * 
	 * @param o
	 */
	public void addSorted(Object o) {
		if (head == null)
			head = new ListElement(o, null);
		else if (((Comparable) head.first()).compareTo(o) > 0) {
			// add the element in front
			head = new ListElement(o, head);
		} else {
			// find the first element which is bigger
			ListElement d = head;
			while ((d.rest() != null) && (((Comparable) d.rest().first()).compareTo(o) < 0)) {
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o, next));
		}
		count++;
	}
}
