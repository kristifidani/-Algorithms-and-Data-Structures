package data.structures;

/**
 * Class representing a Red and Black Tree
 * 
 * @author Kristi
 *
 */
public class RedBlackTree {

	public enum TreeNodeColor {
		Red, Black
	}

	public class ColouredTreeNode implements Comparable {
		protected TreeNodeColor color;
		private Comparable value;
		protected ColouredTreeNode leftNode;
		protected ColouredTreeNode rightNode;
		protected ColouredTreeNode parentNode;

		/**
		 * @return the value
		 */
		public Comparable getValue() {
			return value;
		}

		/**
		 * @param value
		 */
		public void setValue(Comparable value) {
			this.value = value;
		}

		/**
		 * @param value
		 * @param color
		 */
		public ColouredTreeNode(Comparable value, TreeNodeColor color) {
			this.setValue(value);
			this.color = color;
		}

		@Override
		public String toString() {
			if (getValue() == null) {
				return "nil : " + color;
			} else {
				return getValue().toString() + " : " + color;
			}
		}

		@Override
		public int compareTo(Object arg0) {
			ColouredTreeNode node2 = (ColouredTreeNode) arg0;
			return getValue().compareTo(node2.getValue());
		}
	}

	protected ColouredTreeNode root;
	protected ColouredTreeNode nilNode;
	private int count;

	public RedBlackTree() {
		nilNode = new ColouredTreeNode(null, TreeNodeColor.Black);
		root = nilNode;
		setCount(0);
	}

	/**
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @param x
	 */
	private void rotateLeft(ColouredTreeNode x) {
		ColouredTreeNode y = x.rightNode;
		x.rightNode = y.leftNode;
		if (y.leftNode != nilNode) {
			y.leftNode.parentNode = x;
		}
		y.parentNode = x.parentNode;
		if (x.parentNode == nilNode) {
			root = y;
		} else if (x == x.parentNode.leftNode) {
			x.parentNode.leftNode = y;
		} else {
			x.parentNode.rightNode = y;
		}
		y.leftNode = x;
		x.parentNode = y;
	}

	/**
	 * @param y
	 */
	private void rotateRight(ColouredTreeNode y) {
		ColouredTreeNode x = y.leftNode;
		y.leftNode = x.rightNode;
		if (x.rightNode != nilNode) {
			x.rightNode.parentNode = y;
		}
		x.parentNode = y.parentNode;
		if (y.parentNode == nilNode) {
			root = x;
		} else if (y == y.parentNode.rightNode) {
			y.parentNode.rightNode = x;
		} else {
			y.parentNode.leftNode = x;
		}
		x.rightNode = y;
		y.parentNode = x;
	}

	/**
	 * @param element
	 */
	public void rbInsert(Comparable element) {
		ColouredTreeNode z = new ColouredTreeNode(element, TreeNodeColor.Red);
		ColouredTreeNode y = nilNode;
		ColouredTreeNode x = root;
		while (!(x == nilNode)) {
			y = x;
			if (z.compareTo(x) < 0) {
				x = x.leftNode;
			} else {
				x = x.rightNode;
			}
		}
		z.parentNode = y;
		if (y == nilNode) {
			root = z;
		} else if (z.compareTo(y) < 0) {
			y.leftNode = z;
		} else {
			y.rightNode = z;
		}
		z.leftNode = nilNode;
		z.rightNode = nilNode;
		setCount(getCount() + 1);
		fixUpInsert(z);
	}

	/**
	 * @param z
	 */
	private void fixUpInsert(ColouredTreeNode z) {
		while ((z.parentNode != null) && (z.parentNode.parentNode != null) && z.parentNode.color == TreeNodeColor.Red) {
			if (z.parentNode == z.parentNode.parentNode.leftNode) {
				ColouredTreeNode y = z.parentNode.parentNode.rightNode;
				if (y.color == TreeNodeColor.Red) {
					z.parentNode.color = TreeNodeColor.Black;
					y.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					z = z.parentNode.parentNode;
				} else {
					if (z == z.parentNode.rightNode) {
						z = z.parentNode;
						rotateLeft(z);
					}
					z.parentNode.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					rotateRight(z.parentNode.parentNode);
				}
			} else {
				ColouredTreeNode y = z.parentNode.parentNode.leftNode;
				if (y.color == TreeNodeColor.Red) {
					z.parentNode.color = TreeNodeColor.Black;
					y.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					z = z.parentNode.parentNode;
				} else {
					if (z == z.parentNode.leftNode) {
						z = z.parentNode;
						rotateRight(z);
					}
					z.parentNode.color = TreeNodeColor.Black;
					z.parentNode.parentNode.color = TreeNodeColor.Red;
					rotateLeft(z.parentNode.parentNode);
				}
			}
		}
		if (z == root) {
			root.color = TreeNodeColor.Black;
		}
	}

	public void recPrint() {
		Queue t = new Queue();
		t.push(root);
		while (!t.empty()) {
			ColouredTreeNode n = (ColouredTreeNode) t.pop();
			if (n.leftNode != nilNode) {
				t.push(n.leftNode);
			}
			if (n.rightNode != nilNode) {
				t.push(n.rightNode);
			}
			if (n != nilNode) {
				System.out.println(n + "\n");
			}
		}
	}

	/**
	 * @param object
	 * @param node
	 * @return
	 */
	private Object find(Comparable object, ColouredTreeNode node) {
		nilNode.setValue(object);
		for (;;) {
			if (object.compareTo(node.getValue()) < 0)
				node = node.leftNode;
			else if (object.compareTo(node.getValue()) > 0)
				node = node.rightNode;
			else if (node != nilNode)
				return node.getValue();
			else
				return null;
		}
	}

	/**
	 * @param obj
	 * @return
	 */
	public Object find(Comparable obj) {
		return find(obj, root);
	}

	/**
	 * Traverses the tree and returns a Queue
	 * 
	 * @param action
	 * @return
	 */
	public Queue traverseInOrderQ(RbTreeAction action) {
		Queue data = new Queue();
		Queue t = new Queue();
		t.push(root);
		while (!t.empty()) {
			ColouredTreeNode n = (ColouredTreeNode) t.pop();
			if (n.leftNode != nilNode) {
				t.push(n.leftNode);
			}
			action.run(n);
			Object ob = action.runObj(n);
			if (ob != null) {
				data.push(ob);
			}
			if (n.rightNode != nilNode) {
				t.push(n.rightNode);
			}
		}
		return data;
	}

	/**
	 * Traverses the tree and returns a Vector
	 * 
	 * @param action
	 * @return
	 */
	public Vector traverseInOrderV(RbTreeAction action) {
		Vector data = new Vector(getCount());
		Queue t = new Queue();
		t.push(root);
		while (!t.empty()) {
			ColouredTreeNode n = (ColouredTreeNode) t.pop();
			if (n.leftNode != nilNode) {
				t.push(n.leftNode);
			}
			action.run(n);
			Object ob = action.runObj(n);
			if (ob != null) {
				data.addLast(ob);
			}
			if (n.rightNode != nilNode) {
				t.push(n.rightNode);
			}
		}
		return data;
	}
}
