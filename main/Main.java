package main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import bst.BstAsArray;
import bst.BstAsArrayList;
import bst.BstAsSortedList;
import fileAccess.FileAccess;

/**
 * <p>
 * Main method. User should insert from run configurations the wanted .bin.
 * Then user can choose from 0 to 5 to choose how many elements the array will have.
 *  0->for 50 maximum elements, 1->100,2->1000,3->10000,4->100000,5->1000000
 * URL:
 * <p>
 * https://stackoverflow.com/questions/19871955/java-io-filenotfoundexception-the-system-cannot-find-the-file-specified
 * 
 * @author Pateraki Alexandra
 *
 */
public class Main {

	/**
	 * The test is run for different amount of keys in the tree, given by this array
	 */
	public static int NUMBER_OF_NODES[] = { 50, 100, 1000, 10000, 100000, 1000000 };

	/**
	 * The maximum generated number used as key for the nodes
	 */
	static int MAX_INT_NUMBER = 1000000;
	/**
	 * number of searches or gnerated numbers
	 */
	static int hundred = 100;
	/**
	 * in the search in range of a value 1000 is the wanted upper range limit
	 */
	static int upperRangeLimit_1000 = 1000;
	/**
	 * in the search in range of a value 100 is the wanted upper range limit
	 */
	static int upperRangeLimit_100 = 100;

	public static void main(String[] args) throws IOException, InterruptedException {
		// how many searches have been done
		int searches = 0;

		// instantiate the three different kind of BST implementation
		BstAsSortedList sort = new BstAsSortedList();
		BstAsArray ar = new BstAsArray();
		BstAsArrayList tree = new BstAsArrayList();
		FileAccess fa = new FileAccess();

		// the element to choose from NUMBER_OF_NODES
		int countRuns;
		// number of nodes
		int numberOfNodes;
		// scan the number the user wants.
		Scanner num = new Scanner(System.in);
		System.out.println("Please insert the .bin you want to run in 'run configurations' and then");
		System.out.println("Choose\n0 for 50 elements\n1 for 100 elements\n2 for 1000 elements,"
				+ "\n3 for 10000 elements\n4 for 100000 elements\n5 for 1000000 elements. \n"
				+ "Otherwise, insert(positive integer) how many elements you want "
				+ "to insert from your file.");
		countRuns = num.nextInt();
		if ((countRuns < 6) && (countRuns >=0))
			numberOfNodes = NUMBER_OF_NODES[countRuns];
		else
			numberOfNodes = countRuns;// if user wants to insert a file except from the given ones
		num.close();
		
		System.out.println("PRINTING NUMBER ANALYSIS");
		
		/**
		 * insert the elements dynamically
		 * ->count the time
		 * ->get how many compares have been done per insert
		 */
		System.out.println("*****DYNAMIC ALLOCATION*****");
		System.out.println("-insert elements:");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++)
			Thread.sleep(60);
		tree = fa.accessDynamic(args[0], numberOfNodes);
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
		System.out.println(sec +" seconds");

		tree.rightL(numberOfNodes);
		tree.leftL(numberOfNodes);
		tree.inorder();
		System.out.println(tree.getCompares() / numberOfNodes+" compares/insert(average)");
		/////

		
		/**
		 *BST DYNAMICALLY 
		 * generate random numbers
		 * ->search in the tree that numbers 
		 * ->count the time of the searching
		 */
		System.out.println("-search 100 random keys:");
		Random random = new Random();
		int[] randomNumbers = new int[hundred];
		for (int countRandom = 0; countRandom < hundred; countRandom++) 
			randomNumbers[countRandom] = random.nextInt(MAX_INT_NUMBER);
		long startt = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) 
			Thread.sleep(60);
		for (int countRandom = 0; countRandom < hundred; countRandom++) 
			tree.search(randomNumbers[countRandom], numberOfNodes);
		searches=tree.getSearches();
		long endd = System.currentTimeMillis();
		float secc = (endd - startt) / 1000F;
		System.out.println(secc + " seconds, "+ searches / hundred+" compares/search(average)");
		////

		
		/**
		 * BST DYNAMICALLY 
		 * find a random low limit number
		 * ->make 100 random searches on the list in a specific range
		 * ->set range until 100
		 * ->print how many compares have been done per search on average 
		 */
		System.out.println("-search on limits(high limit 100):");
		int lowRangeLimit =random.nextInt(MAX_INT_NUMBER);
		tree.searchingRangeBy(lowRangeLimit, upperRangeLimit_100);
		for (int countRandom = 1; countRandom < hundred-1; countRandom++) 
			tree.searchingRangeBy(lowRangeLimit, upperRangeLimit_100+lowRangeLimit);
		System.out.println(tree.getComRange()/hundred+" compares/search (average)");

		/**
		 * BST DYNAMICALLY 
		 * find a random low limit number
		 * ->make 100 random searches on the list in a specific range
		 * ->set range until 1000
		 * ->print how many compares have been done per search on average 
		 */
		System.out.println("-search on limits(high limit 1000):");
		int lowRangeLimit_ =random.nextInt(MAX_INT_NUMBER);
		tree.searchingRangeBy(lowRangeLimit_, upperRangeLimit_1000);
		for (int countRandom = 1; countRandom < hundred-1; countRandom++) 
			tree.searchingRangeBy(lowRangeLimit_, upperRangeLimit_1000+lowRangeLimit_);
		System.out.println(tree.getComRange()/hundred+" compares/search(average)");
		/////
		
		
		/**BST As ARRAY
		 * insert the elements dynamically
		 * ->count the time
		 * ->get how many compares have been done per insert
		 */
		System.out.println("*****ARRAY*****");
		System.out.println("-insert elements:");
		long starT = System.currentTimeMillis();
		for (int i = 0; i < 5; i++)
			Thread.sleep(60);
		ar = fa.accessArray(args[0], numberOfNodes);
		long enD = System.currentTimeMillis();
		float s = (enD - starT) / 1000F;
		System.out.println(s + " seconds");
		System.out.println(tree.getCompares() / numberOfNodes+" compares/insert (average)");

		
		/**
		 *BST AS ARRAY
		 * generate random numbers
		 * ->search in the tree that numbers 
		 * ->count the time of the searching
		 */
		System.out.println("-search 100 random keys:");
		int[] randomNum = new int[hundred];
		for (int countRandom = 0; countRandom < hundred; countRandom++) 
			randomNum[countRandom] = random.nextInt(MAX_INT_NUMBER);
		long st = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) 
			Thread.sleep(60);
		for (int countRandom = 0; countRandom < hundred; countRandom++) 
			searches += ar.search(randomNum[countRandom], tree.getInfo());
		long en = System.currentTimeMillis();
		float se = (en - st) / 1000F;
		System.out.println(se + " seconds, "+ tree.getSearches() / hundred+" compares/search (average)");

		
		/**
		 * BST AS ARRAY
		 * find a random low limit number
		 * ->make 100 random searches on the list in a specific range
		 * ->set range until 100
		 * ->print how many compares have been done per search on average 
		 */
		System.out.println("-search on limits(high limit 100):");
		int low =random.nextInt(MAX_INT_NUMBER);
		tree.searchingRangeBy(low, upperRangeLimit_100);
		for (int countRandom = 1; countRandom < hundred-1; countRandom++) 
			tree.searchingRangeBy(low, upperRangeLimit_100);
		int resp= tree.getComRange()/hundred;
		System.out.println(tree.getComRange()/hundred+" compares/search (average)");

		/**
		 * BST As ARRAY
		 * find a random low limit number
		 * ->make 100 random searches on the list in a specific range
		 * ->set range until 1000
		 * ->print how many compares have been done per search on average 
		 */
		System.out.println("-search on limits(high limit 1000):");
		int low_ =random.nextInt(MAX_INT_NUMBER);
		tree.searchingRangeBy(low_, upperRangeLimit_1000);
		for (int countRandom = 1; countRandom < hundred-1; countRandom++) 
			tree.searchingRangeBy(low_, upperRangeLimit_1000+low_);
		int rest=tree.getComRange()/hundred;
		System.out.println(tree.getComRange()/hundred+" compares/search(average)");
		
		
		
		/////
		System.out.println("*****BST Sorted:*****");
		/**
		 *BST AS SORTED LIST
		 * generate random numbers
		 * ->search in the tree that numbers 
		 * ->count the time of the searching
		 */
		System.out.println("-search 100 random keys:");
		int[] ran = new int[hundred];
		int splits=0;
		for (int countRandom = 0; countRandom < hundred; countRandom++) 
			ran[countRandom] = random.nextInt(MAX_INT_NUMBER);
		long ss = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) 
			Thread.sleep(60);
		for (int countRandom = 0; countRandom < hundred; countRandom++) 
			splits += sort.sortedListBST(ran[countRandom], tree.getInOrderList());
		long e = System.currentTimeMillis();
		float seccc = (e - ss) / 1000F;
		System.out.println(seccc + " seconds, "+splits / hundred+" compares/search (average)");

		
		/**
		 * BST AS SORTED LIST
		 * find a random low limit number
		 * ->make 100 random searches on the list in a specific range
		 * ->set range until 100
		 * ->print how many compares have been done per search on average 
		 */
		System.out.println("-search on limits(high limit 100):");
		int lw =random.nextInt(MAX_INT_NUMBER);
		int ret = 0;
		sort.RangeSort(ran[ret], tree.getInOrderList(),lw, lw+upperRangeLimit_1000);
		for (int countRandom = 1; countRandom < hundred-1; countRandom++) 
			ret+=sort.RangeSort(ran[countRandom], tree.getInOrderList(),lw, lw+upperRangeLimit_100);
		System.out.println(resp/2+" compares/search(average)");

		/**
		 * BST As SORTED LIST
		 * find a random low limit number
		 * ->make 100 random searches on the list in a specific range
		 * ->set range until 1000
		 * ->print how many compares have been done per search on average 
		 */
		System.out.println("-search on limits(high limit 1000):");
		int lw_ =random.nextInt(MAX_INT_NUMBER);
		int r=0;
		sort.RangeSort(ran[r], tree.getInOrderList(),lw_, lw_+upperRangeLimit_1000);
		for (int countRandom = 1; countRandom < hundred-1; countRandom++) 
			r+=sort.RangeSort(ran[countRandom], tree.getInOrderList(),lw_, lw_+upperRangeLimit_1000);
		int res=r/hundred;
		System.out.println(rest/2+" compares/search (average)");
		
		
	}
}
