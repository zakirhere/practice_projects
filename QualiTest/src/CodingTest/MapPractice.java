package CodingTest;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Attr;


public class MapPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<Integer, Object> myMap = new HashMap<Integer, Object>();
		//Map myMap = new HashMap();
		int[] r = {1, 3};
		sentAttr attobj = new sentAttr(2, r);
		
		myMap.put(1, attobj);
		r[0] = 2;
		r[1] = 3;
		attobj.oCount = 1;
		attobj.reference = r;
		
		myMap.put(2, attobj);
		
		sentAttr out = (sentAttr) myMap.get(1);
		
		System.out.println(out.word);
		System.out.println(myMap.get(2));

	}


}