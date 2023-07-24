package bst;

/**
 * Interface for the different kind of structures.
 * <p>
 * Methods:insert, search,inorder and searchingRangeBy
 * @author Pateraki Alexandra
 *
 */
public interface SearchDataStructure {
	/**
	 * Inserts new Node with the information being the key
	 * @param key->value to be inserted in the info section of the node
	 * @return void
	 */
	public void insert(int key);
	
	/**
	 * Searching by key to find how many searches have been done in order to find the 
	 * node with the key
	 * @param key->the value that the method is looking for
	 * @param max-> the maximum nodes of the tree
	 */
	public void search(int key, int max);
	
	/**
	 * This method orders the tree inorder
	 */
	public void inorder();
	/**
	 * this method searches in a specific range a specific value
	 * @param k1->low limit
	 * @param k2->high limit
	 */
	public void searchingRangeBy(int k1, int k2); 
}
