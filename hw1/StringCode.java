import java.util.HashSet;
import java.util.Set;


public class StringCode {

	public static String blowup(String str) {
		return blowupFromIndex(str,0);
	}
	
	/**
	 * Recursive function to implement "blowup" functionality.
	 * 
	 * @param str
	 * @param index
	 * @return
	 */
	private static String blowupFromIndex(String str,int index) {
		// if string is empty, nothing to do
		if ( str.length() == 0 ) { return ""; }
		
		String newString = null, token = null;
		StringBuffer buffer = null;
		
		for ( int i=index; i < str.length(); ++i ) {
			char c = str.charAt(i);
			if ( i == str.length() - 1 ) {
				return Character.isDigit(c) ? str.substring(0,i) : str;
			}
			if ( Character.isDigit(c) ) {
				char d = str.charAt(i+1);
				buffer = new StringBuffer();
				int x = Integer.parseInt(Character.toString(c));
				for ( int j=0; j < x; ++j ) {
					buffer.append(d);
				}
				token = buffer.toString();
				newString = str.substring(0,i) + token + str.substring(i+1);
				return blowupFromIndex(newString, i+token.length());
			}
		}
		
		return str;
	}
	
	public static int maxRun(String str) {
		// handle corner cases
		if ( str.length() == 0 ) { return 0; }
		if ( str.length() == 1 ) { return 1; }
		
		// handle general case
		int sample = 0, max = 0;
		for ( int i=0; i < str.length()-1; ++i ) {
			if ( ( sample = countRunFromIndex(str,i)) > max ) {
				max = sample;
			}
		}
		return max;
	}
	
	private static int countRunFromIndex(String str,int index) {
		// if index is out of bounds, throw a new exception
		if ( index < 0 || index > str.length() - 2 ) {
			throw new IllegalArgumentException("Index out of bounds ["+index+"]: "+str);
		}
		
		// size of run will always be at least "1"
		// count to see if it's going to be longer in this case 
		int count = 1;
		for ( int i=index; i < str.length()-1; ++i ) {
			char c = str.charAt(i);
			char d = str.charAt(i+1);
			if ( c == d ) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	
	public static boolean stringIntersect(String a, String b, int len) {
		// the size of intersection must be at least 1
		if ( len < 1 ) {
			throw new IllegalArgumentException("Size of intersection must be at least 1: " + len);
		}
		
		// find the intersection of the two sets
		Set<String> s1 = generateSubstrings(a,len);
		Set<String> s2 = generateSubstrings(b,len);
		
		s1.retainAll(s2);
		return s1.size() > 0;
	}
	
	private static Set<String> generateSubstrings(String str, int len) {
		Set<String> set = new HashSet<String>();
		for ( int i=0; i < str.length() - len + 1; ++i ) {
			set.add(str.substring(i,i+len));
		}
		return set;
	}
}
