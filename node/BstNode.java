package node;

/**
 * Node in a BST.
 * @author Pateraki Alexandra
 *
 */
public class BstNode implements Node {
	/**
	 * key/value/info of the node
	 */
	private int key;
	
	/**
	 * left and right child of the father Node 
	 */
	public BstNode left;

	public BstNode right;

	/**
	 * constructor:
	 * @param item -> the key
	 */
	public BstNode(int item) {
		key = item;
		left = right = null;
	}
	
	/**
	 * getter of the variable of the key
	 * @return the key
	 */
	public int getKey() {
		return key;
	}
}
