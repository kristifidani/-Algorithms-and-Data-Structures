package data.structures;

/**
 * Class representing the Vector data structure
 * 
 * @author Kristi
 *
 */
public class Vector {

	private Object data[];
	private int count;

	/**
	 * @param capacity
	 */
	public Vector(int capacity) {
		data = new Object[capacity];
		count = 0;
	}

	/**
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		return data[index];
	}

	/**
	 * @param index
	 * @param obj
	 */
	public void set(int index, Object obj) {
		data[index] = obj;
	}

	/**
	 * @param obj
	 * @return
	 */
	public boolean contains(Object obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param item
	 */
	public void addFirst(Object item) {
		if (count == data.length) {
			System.out.println("It is full capacity");
		} else {
			for (int i = count; i > 0; i--) {
				data[i] = data[i - 1];
			}
			data[0] = item;
			count++;
		}
	}

	/**
	 * @param N
	 */
	public void addLast(Object N) {
		if (count == data.length) {
			System.out.println("It is full capacity ");
		} else {
			data[count++] = N;
		}
	}

	/**
	 * @return
	 */
	public Object getFirst() {
		return data[0];
	}

	/**
	 * @return
	 */
	public Object getLast() {
		return data[count - 1];
	}

	public void removeLast() {
		data[count - 1] = null;
		count--;
	}

	public void removeFirst() {
		for (int i = 0; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}
		count--;
	}

	@Override
	public String toString() {
		for (Object o : data) {
			if (o != null) {
				System.out.println(o.toString());
			}
		}
		return "Vector{" + '}';
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean binarySearch(int key) {
		int start = 0;
		int end = count - 1;
		while (start <= end) {
			int middle = (start + end + 1) / 2;
			System.out.println("middle is " + middle);
			if (key < (int) data[middle]) {
				end = middle - 1;
				System.out.println("End is " + end);
			} else if (key > (int) data[middle]) {
				start = middle + 1;
				System.out.println("Start is " + start);
			} else {
				return true;
			}
		}
		return false;
	}
}
