package CodingTest;

import java.awt.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


public class BrianAssignment {
	
	static String inputString = "testing a string repeat value of string in a string";
	public static Map<String, Integer> myMap;
	static String[] unsortedStringArray;
	
	@Test
	public void SplitAndSortListInAscendingOrder() {
		myMap = new HashMap<String, Integer>();
		unsortedStringArray = inputString.split(" ");
		Arrays.sort(unsortedStringArray);
		System.out.println(unsortedStringArray.toString());
	}

	@Test (dependsOnMethods = "SplitAndSortListInAscendingOrder")
	public void getWordsWithCounts() {
		for(int i=0; i<unsortedStringArray.length; i++) {
			if(myMap.containsKey(unsortedStringArray[i]))
				myMap.put(unsortedStringArray[i], myMap.get(unsortedStringArray[i]) + 1);
			else
				myMap.put(unsortedStringArray[i], 1);
		}
		
		System.out.println(myMap);
	}
	
	public void getWordsWithCountsAndSentenceReference() {
		
	}
	
	
	
}
