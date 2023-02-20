/**
 * 
 */
package data.structures;

/**
 * Class representing the Stack data structure implemented with Vector
 * 
 * @author Kristi
 *
 */
public class Stack {
	private Vector data;

	public Stack() {
		data = new Vector(100);
	}

	/**
	 * @param o
	 */
	public void push(Object o) {
		data.addFirst(o);
	}

	/**
	 * @return
	 */
	public Object pop() {
		Object temp = data.getFirst();
		data.removeFirst();
		return temp;
	}

	/**
	 * @return
	 */
	public Object top() {
		return data.getFirst();
	}

	public void size() {
		data.size();
	}

	/**
	 * @return
	 */
	public boolean empty() {
		return data.size() == 0;
	}
}