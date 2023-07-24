package bst;

import java.util.ArrayList;


/**
 * This class performs searching the key as the tree is a list.
 * <p>
 * URL:<p> 
 * https://www.geeksforgeeks.org/binary-search/?fbclid=IwAR0FtQGq7I2aF3U8VUOOTzRIH_sv7Y91GoOl8ZJS0Z1-LHWhhOBMCZ2oDYA
 * @author Pateraki Alexandra
 */
public class BstAsArray {
	/**
	 * an array of integers to save the information of the tree
	 */
	Integer arr[];

	/**
	 * get the info array
	 * @return the array
	 */
	public Integer[] getArr() {
		return arr;
	}

	/**
	 * setter of the info array
	 * @param arr
	 * ->the array 
	 * @return void 
	 */
	public void setArr(Integer[] arr) {
		this.arr = arr;
	}

	/**
	 * this method fills the array with the list of the information
	 * @param list
	 * ->the list of the information
	 * @return void
	 */
	public void insertInTheArray(ArrayList<Integer> list) {
		arr = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
	}

	/**
	 * this method searches the key into the arra with a for loop checking every element 
	 * and then going to the next one.
	 * @param key
	 * @param list
	 * @return how many searches have been done
	 * <p>if the search was not successful then it returns 0
	 */
	public int search(int key, ArrayList<Integer> list) {
		int j;
		insertInTheArray(list);
		for (j = 0; j < list.size(); j++)
			if (key == arr[j]) {
				return j + 1;
			}
		return list.size();

	}
	
}
