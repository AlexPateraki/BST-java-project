package bst;

import bst.SearchDataStructure;

import counter.CounterSingleton;
import node.BstNode;

import java.util.ArrayList;

/**
 * A class that implements a Binary Search Tree with dynamic allocation using
 * three Arraylists:
 * <p>
 * info->the information ArrayList of the binary tree,
 * <p>
 * left->the left Arraylist, shows in which line is the left child of a node,
 * <p>
 * right->the right Arraylist, shows in which line is the right child of a node,
 * </p>
 * Methods: setters and getters, the implemented methods and the
 * method,'findTheNode', to find the node by the value.
 * <p>
 * CoutnerSingleton is used to count the number of levels traversed on each
 * search.
 * 
 * @see {@link counter.CounterSingleton CounterSingleton}
 *      </p>
 * 
 * @author Pateraki Alexandra
 *
 */
public class BstAsArrayList implements SearchDataStructure {
	/**
	 * The root of the BST as a Node
	 */
	private BstNode root;
	/**
	 * arrayList of integers to save the information, that means the value of the
	 * node
	 */
	ArrayList<Integer> info = new ArrayList<>();
	/**
	 * arrayList of integers to save in which line the left child of each node is
	 * taking place
	 */
	ArrayList<Integer> left = new ArrayList<>();
	/**
	 * arrayList of integers to save in which line the right child of each node is
	 * taking place
	 */
	ArrayList<Integer> right = new ArrayList<>();
	/**
	 * counter to keep the for loop value
	 */
	public int count = 0;
	/**
	 * the first available element to insert a node
	 */
	public int avail = 0;
	/**
	 * a arraylist that keeps the information-keys in a in-order list
	 */
	ArrayList<Integer> inOrderList = new ArrayList<>();

	/**
	 * how many compares have been done to insert the tree
	 */
	int compares;
	/**
	 * how many compares have been done to search the element on the key on
	 * aspecific range
	 */
	int comRange;
	/**
	 * how many searches have been done to find a key
	 */
	int searches;
	//////////////////// setters and getters/////////////////////////

	/**
	 * getting the ArrayList of the information
	 * 
	 * @return an array list of integers.
	 */
	public ArrayList<Integer> getInfo() {
		return info;
	}

	/**
	 * set an ArrayList as the ArrayList of the information
	 * 
	 * @param info
	 *            ->the Arraylist having the values of the nodes
	 */
	public void setInfo(ArrayList<Integer> info) {
		this.info = info;
	}

	/**
	 * getting the ArrayList of the right childen
	 * 
	 * @return an array list of integers saying where the right childen are taking
	 *         place.
	 */
	public ArrayList<Integer> getRight() {
		return right;
	}

	/**
	 * set an ArrayList as the ArrayList of right children of the nodes
	 * 
	 * @param right
	 *            ->an arraylist keeping the position of the right children
	 */
	public void setRight(ArrayList<Integer> right) {
		this.right = right;
	}

	/**
	 * getting the ArrayList of left children
	 * 
	 * @return an array list of integers saying where the left childen are taking
	 *         place.
	 */
	public ArrayList<Integer> getLeft() {
		return left;
	}

	/**
	 * set the Arraylist of the left children
	 * 
	 * @param left
	 *            ->an arraylist keeping the position of the left children
	 */
	public void setLeft(ArrayList<Integer> left) {
		this.left = left;
	}

	/**
	 * get the array list of the information in-ordered
	 * 
	 * @return the list
	 */
	public ArrayList<Integer> getInOrderList() {
		return inOrderList;
	}

	/**
	 * set the list of the information, which are in-order.
	 * 
	 * @param inOrderList
	 *            -> the arrayList of the in-order list
	 */
	public void setInOrderList(ArrayList<Integer> inOrderList) {
		this.inOrderList = inOrderList;
	}

	/**
	 * get compares variable
	 * 
	 * @return int of compares
	 */
	public int getCompares() {
		return compares;
	}

	/**
	 * set the variable compares
	 * 
	 * @param compares
	 *            -> the variable compares
	 */
	public void setCompares(int compares) {
		this.compares = compares;
	}

	/**
	 * get the variable comRange
	 * 
	 * @return that variable
	 */
	public int getComRange() {
		return comRange;
	}

	/**
	 * set the variable comRange
	 * 
	 * @param comRange
	 *            ->the variable
	 */
	public void setComRange(int comRange) {
		this.comRange = comRange;
	}

	/**
	 * get the variable searches
	 * 
	 * @return variable 'searches'
	 */
	public int getSearches() {
		return searches;
	}

	/**
	 * set the variable searches
	 * 
	 * @param searches
	 */
	public void setSearches(int searches) {
		this.searches = searches;
	}
	//////////////////////////// constructor///////////////////////////////////

	/**
	 * Constructor
	 * <p>
	 * Initializing root -> null, showing that its empty
	 */
	public BstAsArrayList() {
		root = null;
	}

	//////////////////// methods////////////////////////////////////////////
	/**
	 * Used to call insertRec, but it only need the value and not the root of the
	 * List.
	 * 
	 * <pre>
	 * val
	 * </pre>
	 * 
	 * @param val
	 *            -> The value for the key of the new Node
	 * @return void
	 */
	public void insert(int val) {
		root = insertRec(root, val);
	}

	/**
	 * Recursive method which inserts a new node into binary tree. Starting from its
	 * root and moving on the other nodes by checking if the parameter value equals
	 * to the value of the node that the method is at that moment.
	 * 
	 * </p>
	 * As a new node inserts the list, the method adds the value of the node in the
	 * correct position of the ArrayList having the tree information(values).
	 * 
	 * @param insertRoot
	 *            ->The root node to start the insertion process
	 * @param val
	 *            ->The value for the key of the new Node
	 * @return the new node
	 *         <p>
	 *         URL :
	 *         https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	 */
	private BstNode insertRec(BstNode insertRoot, int val) {

		/* If the tree is empty, return a new node */
		if (insertRoot == null) {
			insertRoot = new BstNode(val);
			info.add(val);
			return insertRoot;
		}

		/* Otherwise, recur down the tree */
		if (val < insertRoot.getKey()) {
			compares++;

			insertRoot.left = insertRec(insertRoot.left, val);
		} else if (val > insertRoot.getKey()) {
			compares++;
			insertRoot.right = insertRec(insertRoot.right, val);
		}
		/* return the (unchanged) node reference */
		return insertRoot;

	}

	/**
	 * a helper method to create the array list of the right children. Basically,
	 * calls the rightList method and counts the loops.
	 * 
	 * @param maxNodes
	 *            the maximum number of nodes that the tree can have. This number is
	 *            provided from the main class.
	 * @return void
	 */
	public void rightL(int maxNodes) {
		for (int i = 0; i < maxNodes; i++)
			rightList(root, info.get(i));
	}

	/**
	 * Finds the line that right child of each Node and add it to the 'right' Array
	 * list.
	 * 
	 * @param insertRoot
	 *            -> the gap node
	 * @param val
	 *            ->the value of the information of the tree
	 * @return void
	 */
	public void rightList(BstNode insertRoot, int val) {
		BstNode n;
		int pos = -1;
		int k = 0;
		if ((findTheNode(root, val) != null) && (findTheNode(root, val).right != null)) {
			n = findTheNode(root, val).right;
			while (info.get(k) != n.getKey())
				k++;
			pos = k;
		} else
			pos = -1;
		right.add(pos);

	}

	/**
	 * a helper method to create the array list of the left children. Basically,
	 * calls the leftList method and counts the loops.
	 * 
	 * @param maxNodes
	 *            ->the maximum number of nodes that the tree can have. This number
	 *            is provided from the main class.
	 * @return void
	 */
	public void leftL(int maxNodes) {
		for (int i = 0; i < maxNodes; i++)
			leftList(root, info.get(i));
	}

	/**
	 * Finds the line that left child of each Node and add it to the 'left' Array
	 * list. This method, also, removes the element of the 'left' ArrayList because
	 * it has been initializes in the fillStack(int maxNodes) method, which is
	 * called at the start of the program.
	 * 
	 * @param insertRoot
	 *            -> the gap node
	 * @param val
	 *            ->the value of the information of the tree
	 * @return void
	 */
	public void leftList(BstNode insertRoot, int val) {
		BstNode n;
		int pos = -1;
		int k = 0;
		if ((findTheNode(root, val) != null) && (findTheNode(root, val).left != null)) {
			n = findTheNode(root, val).left;
			while (info.get(k) != n.getKey())
				k++;
			pos = k;
		} else
			pos = -1;

		left.remove(count);
		left.add(count, pos);
		count++;
	}

	/**
	 * The method is called at the start of the main and it fills the left column
	 * (Array List 'left') with numbers to show in which line it has gap. So this
	 * method, fills the STACK with a for loop. A the end of the stack the value is
	 * -1.
	 * 
	 * @param maxNodes
	 *            ->the maximum number of nodes that the tree can have. This number
	 *            is provided from the main class.
	 * @return void
	 */
	public void fillStack(int maxNodes) {
		int i;
		for (i = 1; i < maxNodes; i++) {
			left.add(i);
		}
		if (i == maxNodes) {
			left.add(-1);
			avail = maxNodes;
		}

	}

	/**
	 * call doSearch
	 * 
	 * @param val
	 *            ->value which is searched
	 * @param max->
	 *            maximum number of nodes
	 */
	public void search(int val, int max) {
		doSearch(root, val, max);
	}

	/**
	 * the method counts the searches from the parent until the wanted value using a
	 * for loop
	 * 
	 * @param searchRoot->
	 *            the parent node
	 * @param val
	 *            -> the value that i want to be equal in the for loop
	 * @param max
	 *            -> the maximum number of the elements of the tree
	 */
	private void doSearch(BstNode searchRoot, int val, int max) {

		// for (int i = 0; i < max; i++) {
		// if (info.get(i) == val)
		// return searches + 1;
		if (searchRoot.getKey() > val) {// go left the val is smaller
			searches++;
			if (searchRoot.left != null) {
				if (searchRoot.left.getKey() > val)
					doSearch(searchRoot.left, val, max);
				else
					doSearch(searchRoot.right, val, max);
			} else
				return;
		} else if (searchRoot.getKey() < val) {// go right the value is greater
			searches++;
			if (searchRoot.right != null) {
				if (searchRoot.right.getKey() > val)
					doSearch(searchRoot.right, val, max);
				else
					doSearch(searchRoot.right, val, max);
			} else
				return;
		} else
			return;
	}

	/**
	 * calls InorderRec()-keeps root. Always calling with the parent of the tree
	 * 
	 * @return void
	 */
	public void inorder() {
		inorderF(root);

	}

	/**
	 * make the list inorder
	 * 
	 * @param insertRoot
	 *            ->the parent
	 * @return void
	 */
	public void inorderF(BstNode insertRoot) {
		if (insertRoot != null) {
			inorderF(insertRoot.left);
			inOrderList.add(insertRoot.getKey());
			setInOrderList(inOrderList);
			inorderF(insertRoot.right);
		}

	}

	/**
	 * This method calls the searchRange method and keeps the root
	 * 
	 * @param k1
	 *            -> low limit
	 * @param k2
	 *            -> high limit
	 * @return void
	 */
	public void searchingRangeBy(int k1, int k2) {
		searchRange(root, k1, k2);
	}

	/**
	 * Searching in a specific range using the inorder traversal, as inorder
	 * traversal of a BST gives the keys in sorted order.
	 * 
	 * @param node
	 *            ->the node that i want to search
	 * @param k1
	 *            -> the lower limit
	 * @param k2
	 *            -> the upper limit
	 * @return void
	 *         <p>
	 *         URL: https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
	 */
	public void searchRange(BstNode node, int k1, int k2) {

		/* base case */
		if (node == null) {
			return;
		}

		/*
		 * Since the desired o/p is sorted, recurse for left subtree first If root->data
		 * is greater than k1, then only we can get o/p keys in left subtree
		 */
		if (k1 < node.getKey()) {
			comRange++;
			searchRange(node.left, k1, k2);
		}

		/* if root's data lies in range, then prints root's data */
		if (k1 <= node.getKey() && k2 >= node.getKey()) {
			comRange++;
			System.out.print(node.getKey() + "\t");
		}

		/*
		 * If root->data is smaller than k2, then only we can get o/p keys in right
		 * subtree
		 */
		if (k2 > node.getKey()) {
			comRange++;
			searchRange(node.right, k1, k2);
		}
	}

	/**
	 * find a node recursively by the value of the nodes
	 * 
	 * @param searchRoot
	 *            -> the parent
	 * @param val
	 *            -> the value number that the method is looking for
	 * @return the node which contains the parameter value
	 */
	private BstNode findTheNode(BstNode searchRoot, int val) {
		CounterSingleton counter = CounterSingleton.getInstance();
		counter.increaseCounter();
		// Base Cases: root is null or key is present at searchRoot
		if (searchRoot == null || searchRoot.getKey() == val) {
			return searchRoot;
		}

		// searched value is less than the current nodes key
		if (searchRoot.getKey() > val)
			return findTheNode(searchRoot.left, val);

		// searched value is greater than the current nodes key. Recursively call
		return findTheNode(searchRoot.right, val);
	}

}
