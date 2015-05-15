/** QuickSortAlgorithm
 * 
 * This class will implement the QuickSort algorithm.
 * The class will take in a List of Strings in the constructor then Sort the list in order
 * using a divide and conquer style sort.
 */
package quicksort_filereader;

import java.util.ArrayList;
import java.util.List;

public class QuickSortAlgorithm {
	
	List<String> sortedList;
	
	/**Constructor
	 * This will take in the List wordList passed into the parameter and store it in the sortedList
	 * @param wordList
	 */
	public QuickSortAlgorithm(List<String> wordList)
	{
		sortedList = Divide(wordList);
	}
	
	/**This returns the List sortedList
	 * 
	 * @return
	 */
	public List<String> getSortedList()
	{
		return sortedList;
	}
	
	/**QuickSort Algorithm: Divide
	 * This will implement the QuickSort by dividing the list in half
	 * and comparing each element according to the pivot variable and storing them
	 * in the appropriate list.
	 * @param list
	 * @return
	 */
	private static List<String> Divide(List<String> list)
	{
		// Check to see if the list is just one element
		if(list.size() <= 1){
			return list; // no need to sort
		}
		
		int middle = (int) Math.ceil((double)list.size() / 2); //Finds the middle index in the list
		String pivot = list.get(middle); // Store this element in a pivot variable to be compared
 
		//List of elements that are of less value than the pivot
		List<String> less = new ArrayList<String>();
		
		// List of elements that are equivalent to the pivot
		List<String> duplicates = new ArrayList<String>(); 
		
		//List of elements that are of greater value than the pivot
		List<String> greater = new ArrayList<String>();
		
		/** Loop through the entire list comparing each element to the pivot */
		for(String x : list){
			
			if(x.compareTo(pivot) < 0)
			{
				// Value is less
				less.add(x); // store in less List
			}
			else if(x.compareTo(pivot) == 0)
			{
				duplicates.add(x); // Store in Dup List
			}
			else
			{
				greater.add(x); // Store in Greater List
			}
		}
		
		// Return the list after joining all three compared Lists
		return Conquer(Divide(less), duplicates, Divide(greater));
		
	}
	
	/**Method: Conquer 
	 * This method will merge all three lists into a new List to be returned as the Sorted List
	 * 
	 * @param less
	 * @param duplicates
	 * @param greater
	 * @return list
	 */
	private static List<String> Conquer(List<String> less, List<String> duplicates, List<String> greater){
		
		List<String> list = new ArrayList<String>();
		
		for(String x : less)
		{
			list.add(x);
		}
		
		for(String x : duplicates)
		{
			list.add(x);
		}
		
		for(String x : greater)
		{
			list.add(x);
		}
		
		return list;
	}
}
