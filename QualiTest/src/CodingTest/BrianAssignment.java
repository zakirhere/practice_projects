package CodingTest;

import java.awt.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class BrianAssignment {
	
	static String inputString = "Zakir is QA developer. Nasir is developer. Zakir is great guy.";
	static Map<String, Object> outputMap = new HashMap<String, Object>();
	static String[] sentenceArray;
	
	
	public static void main(String[] args) {
		BrianAssignment t1 = new BrianAssignment();
		t1.PrepareSentenceArray();
		t1.getWordFrequency();
		t1.showOutput();
//		sentAttr out = (sentAttr) outputMap.get("Nasir");
//		
//		System.out.println("Reference = " + out.reference);
//		System.out.println("Count = " + out.oCount);
		
	}
	
	public void PrepareSentenceArray() {
		sentenceArray = inputString.split("\\.");
	}
	
	public void getWordFrequency() {
		String[] sentString;
		int count;
		String ref;
		for(int i=0; i<sentenceArray.length; i++) {
			sentenceArray[i] = sentenceArray[i].trim();
			sentString = sentenceArray[i].split(" ");
			for(int j=0; j<sentString.length; j++) {
				if(outputMap.containsKey(sentString[j])) {
					count = ((sentAttr) outputMap.get(sentString[j])).oCount;
					ref = ((sentAttr) outputMap.get(sentString[j])).reference;
					sentAttr st = new sentAttr(count++);
					if(ref != null)
						st.reference = ref + ", " + Integer.toString(i+1);
					outputMap.put(sentString[j], st);
					
				}
				else
				{
					sentAttr st = new sentAttr(1);
					st.reference = Integer.toString(i+1);
					outputMap.put(sentString[j], st);
				}
			}
		}
	}
	
	
	public void showOutput() {
		//sentAttr out = (sentAttr) outputMap.get("Nasir");
		String[] keyArray;
		Set<String> mySet = outputMap.keySet();
		
		keyArray = (String[]) mySet.toArray();
		for(int i=0; i<outputMap.size(); i++) {
			sentAttr out = (sentAttr) outputMap.get(keyArray[i]);
			
			System.out.println("Reference = " + out.reference);
			System.out.println("Count = " + out.oCount);
		}
	}
	
	
}
