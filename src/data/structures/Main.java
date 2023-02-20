package data.structures;

/**
 * @author Kristi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println("Queue pop: " + q.pop());

		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("Stack pop: " + s.pop());

		Vector v = new Vector(5);
		v.addLast("A");
		v.addFirst("B");
//		v.toString();

		Graph g = new Graph();

		PriorityQueue l = new PriorityQueue();

		// Add wings
		g.addNode("A");
		g.addNode("B");
//		g.print();
		// Connect wings
		g.addEdge("A", "B", 10);

	}

}
