import java.util.HashSet;
import java.util.Set;


public class StringCode {

	/**
	 * Given a string, for each digit in the original string, replaces 
	 * the digit with that many occurrences of the character following it.
	 * So the string "a3tx2z" yields "attttxzzz".
	 * 
	 * @param str Argument string in which replacements are to be made.
	 * @return A string in which all the replacements have been made. 
	 */
	public static String blowup(String str) {
		return blowupFromIndex(str,0);
	}
	
	/**
	 * Recursive helper function for blowup(String str). Performs the same 
	 * functions as blowup, only starting at the given index and working outwards.
	 * Procedure is re-invoked recursively each time a new digit is found 
	 * (unless the digit is at the end).
	 * 
	 * @param str Argument string to be "blown up"
	 * @param index Point at which to start looking for digits to "blow up"
	 * @return A string which has been "blown up", counting from index. 
	 *
	 */
	private static String blowupFromIndex(String str,int index) {
		// if string is empty, nothing to do
		if ( str.length() == 0 ) { return ""; }
		
		// set up variables 
		String newString = null, token = null;
		StringBuffer buffer = null;
		
		// start at index, and step forward, stopping if we find any digits 
		for ( int i=index; i < str.length(); ++i ) {
			// check if we are at the end, and if so terminate recursion
			char c = str.charAt(i);
			if ( i == str.length() - 1 ) {
				return Character.isDigit(c) ? str.substring(0,i) : str;
			}
			
			// build a new string and recursively invoke the
			// procedure on the remaining string elements 
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
		
		// terminate recursion, if necessary 
		return str;
	}
	
	/**
	 * Given a string, return the length of the longest run. A run 
	 * is a series of adjacent chars that are all the same.
	 * 
	 * @param str Argument string in which to find the longest run of a single character.
	 * @return int An int representing the longest "run" of a single character in the string.
	 *
	 */
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
	
	/**
	 * Given the argument string, find the character at the specified index 
	 * and count how far the "run" extends from that index. Answer must be at
	 * least "1", since at least that character itself is in the "run". The 
	 * specified index must be between 0 and str.length() - 2.
	 * 
	 * @param str String in which to count the length of the "run".
	 * @param index Index at which to begin counting the length of the "run".
	 * @return Length of the run. Will always be at least 1. 
	 */
	private static int countRunFromIndex(String str,int index) {
		// if index is out of bounds, throw a new exception
		if ( index < 0 || index > str.length() - 2 ) {
			throw new IllegalArgumentException("Index out of bounds ["+index+"]: "+str);
		}
		
		// count the run, starting at index (will always be at least "1")
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
	
	/**
	 * Scans the two argument strings, "a" and "b", for common substrings of length "len".
	 * Returns True if the two strings share one or more substrings of length "len" in common, 
	 * otherwise returns False. 
	 * 
	 * @param a First argument string to check for common substrings.
	 * @param b Second argument string to check for common substrings.
	 * @param len Maximum length of the common substring. Must be 1 or greater.
	 * @return True if a and b share one or more substrings in common of length "len", otherwise returns False.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		// the size of intersection must be at least 1
		if ( len < 1 ) {
			throw new IllegalArgumentException("Size of intersection must be at least 1: " + len);
		}
		
		// generate the substrings 
		Set<String> s1 = generateSubstrings(a,len);
		Set<String> s2 = generateSubstrings(b,len);
		
		// find the intersection
		s1.retainAll(s2);
		return s1.size() > 0;
	}
	
	/**
	 * Generate a collection (Set<String>) of strings by parsing the argument String
	 * into substrings, each of length "len".
	 * 
	 * @param str Argument string to be parsed into substrings of length "len".
	 * @param len Length of the parsed substrings.
	 * @return Set<String> of all substrings of "str" of length "len".
	 */
	private static Set<String> generateSubstrings(String str, int len) {
		Set<String> set = new HashSet<String>();
		for ( int i=0; i < str.length() - len + 1; ++i ) {
			set.add(str.substring(i,i+len));
		}
		return set;
	}
}
