/** Garrett Head
 *  CSCI 308
 *  Project 2
 *  
 *  This project will focus on Sorting Lists of strings.
 *  A Text file will be read in and stored in a List
 *  This list will then be passed into the QuickSortAlgorithm class to be sorted in order
 *  then pass the new sorted list back to the main.
 *  The new sorted list will be printed into a new Output text file.
 */

package quicksort_filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class Main {

	/**MAIN
	 * This will control the flow of the program.
	 * The user will choose a file or create a new file using the JFileChooser
	 * then calling the QuickSortAlgorithm to sort the file and send it to a new output File
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args)  throws  FileNotFoundException {
		
		Scanner Input = null;
		List<String> wordList = new ArrayList<String>();
		PrintWriter Output = null;
		JFileChooser chooser= new JFileChooser();
		QuickSortAlgorithm sortedList;
		
		// Select or create an input file to be read in using the scanner
		System.out.println("Input File Opened...");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File InputFile = chooser.getSelectedFile();
			Input = new Scanner(InputFile);			
		}
		System.out.println("Input File Read\n");
		
		// Select or create an output file to write the sorted list using the PrintWriter
		System.out.println("Output File Opened...");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File OutputFile = chooser.getSelectedFile();
			Output = new PrintWriter(OutputFile);
		}
		System.out.println("Output File Read\n");		
	    
		// Read the file one line at a time
		while (Input.hasNextLine())
	    {
	        wordList.add(Input.next());
	    }
	   
		// Call the QuickSortAlgorithm class to sort the list and store it in the sortedList
		sortedList = new QuickSortAlgorithm(wordList);
		
		// Displays the Unsorted List in the console
		System.out.println("_____UnSorted List_____");
		for(String x : wordList)
		{
			 System.out.print(x + " ");
		}
		System.out.println("");
		
		// Displays the Sorted List in the console and writes it to the Output File
		System.out.println("\n_____Sorted List_____");		
		for(String y : sortedList.getSortedList())
		{
			 System.out.print(y + " ");
			 Output.print(y + " ");	
		}
		
		// Close the files
		Input.close();		
		Output.close();	
		System.out.println("\n\nAll Files Closed");		
	    
		
	}	
}

