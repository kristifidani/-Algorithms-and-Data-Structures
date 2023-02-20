package data.structures;

/**
 * Class representing the Graph data structure implemented with Vector
 * 
 * @author Kristi
 *
 */
public class Graph {
	public class Node implements Comparable {
		private Comparable info;
		private Vector edges;
		private boolean isVisited = false;

		/**
		 * @param label
		 */
		public Node(Comparable label) {
			info = label;
			edges = new Vector(100);
		}

		/**
		 * @param e
		 */
		public void addEdge(Edge e) {
			edges.addLast(e);
		}

		/**
		 * two nodes are equal if they have the same label
		 */
		public int compareTo(Object o) {
			Node n = (Node) o;
			return n.info.compareTo(info);
		}

		/**
		 * @return
		 */
		public Comparable getLabel() {
			return info;
		}

		/**
		 * @return
		 */
		public boolean isVisited() {
			return isVisited;
		}

		/**
		 * @param isVisited
		 */
		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}
	}

	private class Edge implements Comparable {
		private Node toNode;
		private double distance;

		/**
		 * @param to
		 * @param distance
		 */
		public Edge(Node to, double distance) {
			toNode = to;
			this.distance = distance;
		}

		/**
		 * @return
		 */
		public Node getToNode() {
			return toNode;
		}

		/**
		 * @return
		 */
		public double getDistance() {
			return distance;
		}

		/**
		 * edges are equal if they point to the same node. this assumes that the edges
		 * are starting from the same node.
		 */
		public int compareTo(Object o) {
			Edge n = (Edge) o;
			return n.toNode.compareTo(toNode);
		}
	}

	private Vector nodes;

	public Graph() {
		nodes = new Vector(100);
	}

	/**
	 * @param label
	 */
	public void addNode(Comparable label) {
		nodes.addLast(new Node(label));
	}

	/**
	 * @param nodeLabel
	 * @return
	 */
	private Node findNode(Comparable nodeLabel) {
		Node res = null;
		for (int i = 0; i < nodes.size(); i++) {
			Node n = (Node) nodes.get(i);
			if (n.getLabel() == nodeLabel) {
				res = n;
				break;
			}
		}
		return res;
	}

	/**
	 * Adds edge to a Node and the return path
	 * 
	 * @param nodeLabel1
	 * @param nodeLabel2
	 * @param distance
	 */
	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, double distance) {
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n2, distance));
		n2.addEdge(new Edge(n1, distance));
	}

	/**
	 * Finds the minimum distance between paths/edges
	 * 
	 * @param wingName
	 * @return
	 */
	private double findMinDistance(Vector edges) {
		Vector pathDistances = new Vector(edges.size());
		Vector unvisitedPaths = new Vector(edges.size());
		double min = 0;

		for (int i = 0; i < edges.size(); i++) {
			Edge e = (Edge) edges.get(i);
			Node next = findNode(e.getToNode().getLabel());
			if (!next.isVisited()) {
				pathDistances.addLast(e.getDistance());
				unvisitedPaths.addLast(next.getLabel());
			}
		}
		if (!pathDistances.isEmpty()) {
			min = (double) pathDistances.getFirst();
			for (int i = 0; i < pathDistances.size(); i++) {
				System.out.println("Edge path: " + unvisitedPaths.get(i) + " ->\tDistance: " + pathDistances.get(i));
				if ((double) pathDistances.get(i) < min) {
					min = (double) pathDistances.get(i);
				}
			}
		} else {
			System.out.println("All wings traversed with success! Yay!");
		}
		return min;
	}

	/**
	 * Uses the minimum distance to go to the shortest path.
	 * 
	 * @param wingName
	 */
	public void shortestPath(Comparable wing) {
		Node current = findNode(wing);
		System.out.println("\nCurrent Wing: " + current.getLabel());
		current.setVisited(true);
		if (current.edges.isEmpty()) {
			System.out.println("No wings to be cleaned!");
		} else {
			double shortest = findMinDistance(current.edges);
			for (int i = 0; i < current.edges.size(); i++) {
				Edge e = (Edge) current.edges.get(i);
				Node next = findNode(e.getToNode().getLabel());
				if (e.getDistance() == shortest && !next.isVisited()) {
					System.out.println(
							"\n=> Next Wing: " + next.getLabel() + " -> Shortest Distance: " + e.getDistance());
					next.setVisited(true);
					shortestPath(next.getLabel());
				}
			}
		}
	}
}
