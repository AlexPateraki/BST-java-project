/**
 * In the package bst there are the functions of an BST and three different ways 
 * to search a key: as an Array list , as an array and as a Sorted List.
 */
package bst;
import java.util.ArrayList;

/**
 * this class contains methods to control the searching of a key of a Bst, 
 * which is in a sorted list taken by the in-order structure.   
 * @author Pateraki Alexandra
 *
 */
public class BstAsSortedList {
	/////////////////variables////////////////////////
/**
 * a temporary list that keeps the 'half' of the sorted list that the key belongs
 */
	ArrayList<Integer> list = new ArrayList<Integer>();
	/**
	 * a number that shows the half of the temporary list
	 */
	int half = 0;
	/**
	 * the number of the splits of the list-searches
	 */
	int splits ;

	
//////////////////////methods///////////////////////////////
	/**
	 * this method calls the sortedListBST method
	 * @param key
	 * ->the information/number that the methos searches for
	 * @param ol
	 * ->the list that the key is into
	 * @return how many times the list have been splitted(int) 
	 */
	public int searchSorted(int	key, ArrayList<Integer> ol) {
		return sortedListBST(key, ol);
	}

	/**
	 * The recursive method searches the key in a half list using a temporary list
	 * controlled by if statements.
	 * @param key
	 * ->the information/number that the methos searches for
	 * @param orderList
	 * -> the list that the method will look for the key.Basically orderList is the
 		an in-order list of the information.
	 * @return how many times the list have been splitted(int)
	 */
	public int sortedListBST(int key, ArrayList<Integer> orderList) {

		//first splitting
		if (half == 0) {
			half = orderList.size() / 2;
			splits++;
		} else {//splits >1
			half = list.size() / 2;
			splits++;
		}
		
		if (list.size()!=0) {
			//if key was found
		if (list.get(half) == key) 
			return splits;
		//if key is not on the list
		else if (splits>list.size() / 2)
			return splits;
		}
		
		// if key greater than the element in the position 'half'
		if (key > orderList.get(half)) {
			ArrayList<Integer> li = new ArrayList<Integer>();
			for (int i = 0; i <= half-1; i++) {
				li.add(orderList.get(i + half));
			}
		list=li;
		}
	// if key less than the element in the position 'half'
		 else {
			ArrayList<Integer> lis = new ArrayList<Integer>(); 
			for (int i = 0; i <= half; i++) {
				lis.add(orderList.get(i));
			}
			list=lis;
		}
		return sortedListBST(key, list);
	}
	
	/**
	 * helpful method to call RANSort method 
	 * @param key
	 * -> the value that im looking for
	 * @param orderList
	 * ->ther in order list
	 * @param low
	 * -> the low limit of the range
	 * @param high
	 * -> the upper limit of the range
	 * @return
	 * -> how many searches/compares have been done
	 */
	public int RangeSort(int key, ArrayList<Integer> ol, int low, int high){
		return sortedListBST(key, ol);
}

	/**
	 * method to implement the search in a range but in a sorted list
	 * @param key
	 * -> the value that im looking for
	 * @param orderList
	 * ->ther in order list
	 * @param low
	 * -> the low limit of the range
	 * @param high
	 * -> the upper limit of the range
	 * @return
	 * -> how many searches/compares have been done
	 */
public int RANSort(int key, ArrayList<Integer> orderList, int low, int high) {
	int i;
	ArrayList<Integer> tmp = new ArrayList<Integer>();
	for (i=0;i<orderList.size();i++) {
		if ((i>=low)&&(i<high+1))
		tmp.add(orderList.get(i));
	}
	int comp=sortedListBST(key,tmp);
	return comp;
}

}
