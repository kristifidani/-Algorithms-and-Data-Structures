package data.structures;

/**
 * Class representing a Binary Tree
 *
 * @author Kristi
 *
 */
public class Tree {
	public class TreeNode implements Comparable {
		private Comparable value;
		private TreeNode leftNode;
		private TreeNode rightNode;

		/**
		 * @param v
		 */
		public TreeNode(Comparable v) {
			value = v;
			leftNode = null;
			rightNode = null;
		}

		/**
		 * @param v
		 * @param left
		 * @param right
		 */
		public TreeNode(Comparable v, TreeNode left, TreeNode right) {
			value = v;
			leftNode = left;
			rightNode = right;
		}

		/**
		 * @return
		 */
		public TreeNode getLeftTree() {
			return leftNode;
		}

		/**
		 * @return
		 */
		public TreeNode getRightTree() {
			return rightNode;
		}

		/**
		 * @return
		 */
		public Comparable getValue() {
			return value;
		}

		@Override
		public int compareTo(Object o) {
			return value.compareTo(((TreeNode) o).value);
		}
	}

	private TreeNode root;

	public Tree() {
		root = null;
	}

	/**
	 * @param action
	 */
	public void traverse(TreeAction action) {
		Queue t = new Queue();
		t.push(root);

		while (!t.empty()) {
			TreeNode n = (TreeNode) t.pop();
			action.run(n);

			if (n.getLeftTree() != null)
				t.push(n.getLeftTree());
			if (n.getRightTree() != null)
				t.push(n.getRightTree());
		}
	}

	/**
	 * @param n
	 * @param action
	 */
	public void traverseNode(TreeNode n, TreeAction action) {
		if (n != null) {
			if (n.getLeftTree() != null)
				traverseNode(n.getLeftTree(), action);
			action.run(n);
			if (n.getRightTree() != null)
				traverseNode(n.getRightTree(), action);
		}
	}

	/**
	 * @param action
	 */
	public void traverseInOrder(TreeAction action) {
		traverseNode(root, action);
	}

	public void print() {
		traverseInOrder(new TreeAction() {
			public void run(TreeNode n) {
				if ((n.getLeftTree() == null) && (n.getRightTree() == null)) {
					System.out.println(root);
				} else {
					System.out.println();
				}
			}
		});
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param element
	 */
	public void insert(Comparable element) {
		insertAtNode(element, root, null);
	}

	/**
	 * @param element
	 * @param current
	 * @param parent
	 */
	private void insertAtNode(Comparable element, TreeNode current, TreeNode parent) {
		if (current == null) {
			TreeNode newNode = new TreeNode(element);
			if (parent != null) {
				if (element.compareTo(parent.value) < 0) {
					parent.leftNode = newNode;
				} else {
					parent.rightNode = newNode;
				}
			} else
				root = newNode;
		} else if (element.compareTo(current.value) == 0) {
		} else if (element.compareTo(current.value) < 0) {
			insertAtNode(element, current.getLeftTree(), current);
		} else
			insertAtNode(element, current.getRightTree(), current);

	}

	/**
	 * @param element
	 * @param current
	 * @return
	 */
	private Object findNode(Comparable element, TreeNode current) {
		if (current == null)
			return null;
		else if (element.compareTo(current.value) == 0)
			return current.value;
		else if (element.compareTo(current.value) < 0) {
			return findNode(element, current.getLeftTree());
		} else
			return findNode(element, current.getRightTree());
	}

	/**
	 * @param element
	 * @return
	 */
	public Object find(Comparable element) {
		return findNode(element, root);
	}
}
