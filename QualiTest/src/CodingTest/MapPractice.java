package CodingTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Attr;


public class MapPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<Integer, Object> myMap = new HashMap<Integer, Object>();
		//Map myMap = new HashMap();
		
		sentAttr attobj = new sentAttr(2);
		
		myMap.put(1, attobj);
		attobj.oCount = 1;
		attobj.reference = "2r";
		
		attobj.addReference("2r1");
		myMap.put(2, attobj);
		
		sentAttr out = (sentAttr) myMap.get(1);
		
//		System.out.println(out.reference);
//		System.out.println(out.oCount);
//		System.out.println(myMap.get(2));
		
		Set<Integer> mySet = myMap.keySet();
		System.out.println(mySet.toArray().toString());
		
		

	}


}