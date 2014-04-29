package CodingTest;

import java.awt.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


public class BrianAssignment {
	
	static String inputString = "Zakir is QA developer. Nasir is developer. Zakir is great guy.";
	static Map<String, Object> outputMap = new HashMap<String, Object>();
	static String[] sentenceArray;
	
	
	public static void main(String[] args) {
		BrianAssignment t1 = new BrianAssignment();
		t1.PrepareSentenceArray();
		t1.getWordFrequency();
		
		System.out.println(outputMap.toString());
		
	}
	
	public void PrepareSentenceArray() {
		sentenceArray = inputString.split("\\.");
	}
	
	public void getWordFrequency() {
		String[] sentString;
		int count;
		for(int sentCount=0; sentCount<sentenceArray.length; sentCount++) {
			sentenceArray[sentCount] = sentenceArray[sentCount].trim();
			sentString = sentenceArray[sentCount].split(" ");
			for(int wordind=0; wordind<sentString.length; wordind++) {
				if(outputMap.containsKey(sentString[wordind])) {
					count = ((sentAttr) outputMap.get(sentString[wordind])).oCount;
					outputMap.put(sentString[wordind], count + 1);
				
				}
				else
				{
					
					outputMap.put(sentString[wordind], 1);
				}
			}
		}
	}
	
	public boolean isMyMapsContains(String keyValue) {
		if(outputMap.containsKey(keyValue))
			return true;
		else
			return false;
	}
	
	public Object setAttr(int c, int r) {
		sentAttr obj = new sentAttr(c, r);
	}
	
	
}
