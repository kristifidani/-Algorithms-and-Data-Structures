package data.structures;

/**
 * @author Kristi
 *
 * @param <E>
 */
public abstract class RbTreeAction<E> {

	/**
	 * @param n
	 */
	public abstract void run(RedBlackTree.ColouredTreeNode n);

	/**
	 * @param n
	 * @return
	 */
	public abstract Object runObj(RedBlackTree.ColouredTreeNode n);
}
