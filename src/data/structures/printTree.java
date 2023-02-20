package data.structures;

/**
 * @author Kristi
 *
 */
public class printTree extends TreeAction {

	@Override
	public void run(Tree.TreeNode n) {
		System.out.println(n.getValue());
		System.out.print("\n");

	}

}