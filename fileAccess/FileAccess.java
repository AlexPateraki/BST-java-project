package fileAccess;

import java.io.IOException;
import java.io.RandomAccessFile;
import bst.BstAsArray;
import bst.BstAsArrayList;


/**
 * this class accesses the binary file using RandomAccessFile and also 
 * it controls the inserting of the numbers in the lists. 
 * @author Alexandra Pateraki
 * <p>
 * URL:
 * <p>
 * https://stackoverflow.com/questions/277944/best-way-to-read-structured-binary-files-with-java/278021#278021?newreg=41071676184740c2ad681d32e41aeed6
 * @author Pateraki Alexandra
 */
public class FileAccess {

/**
 * This mehod access the .bin file  and inserts the elements into the tree.So it controls the functions
 * to run at the right time. First create the stack, then insert the elements in the tree, 
 * check the right and left child by calling the functions.
 * @param filename
 * ->the name of the bin file
 * @param max
 * ->the maximum elements existing in the file
 * @return the list that have been made
 * @throws IOException
 */
	public BstAsArrayList accessDynamic(String filename,int max) throws IOException{
		BstAsArrayList tree = new BstAsArrayList();
		RandomAccessFile in = new RandomAccessFile(filename, "r");
		tree.fillStack(max);
		for (int num=0;num<max;num++) 
			tree.insert(in.readInt());
		in.close();
		return tree;
	}
	/**
	 * This method access the .bin file and inserts the elements by calling functions of the
	 * tree using arrays.
	 * @param filename
	 * -> the name of the .bin file
	 * @param max
	 * -> maximum number of the elements.
	 * @return the array tree.
	 * @throws IOException 
	 */
	public BstAsArray accessArray(String filename,int max) throws IOException{
		BstAsArray treeAr = new BstAsArray();
		Integer arr[] = new Integer[max];
		RandomAccessFile in = new RandomAccessFile(filename, "r");
		for (int num=0;num<max;num++) {
			arr[num] = in.readInt();
		}
		treeAr.setArr(arr);
		in.close();
		return treeAr;
			
	}

}
	



