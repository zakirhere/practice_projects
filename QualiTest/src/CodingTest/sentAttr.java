package CodingTest;


public class sentAttr {
	public int oCount;
	public String reference;
	
	public sentAttr(int c) {
		this.oCount = c;
		
	}
	
	public void addReference(String r) {
		if(this.reference != null)
			r = this.reference + ", " + r;
		
		this.reference = r;
	}
}