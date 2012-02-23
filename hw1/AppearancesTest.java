import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppearancesTest {
	@Test
	public void testCount1() {
		List<String> s1 = stringToList("ababc");
		List<String> s2 = stringToList("caadbbb");
		
		assertEquals( 2, Appearances.sameCount(s1, s2));
	}
	
	@Test
	public void testCount2() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		List<String> c = stringToList("ccbcab");
		List<String> d = stringToList("bcabcc");
		
		assertEquals( 3, Appearances.sameCount(a, b));
		assertEquals( 3, Appearances.sameCount(a, c));
		assertEquals( 3, Appearances.sameCount(c, b));
		assertEquals( 3, Appearances.sameCount(d, b));
	}
	
	// private helper method
	private List<String> stringToList(String str) {
		List<String> list = new ArrayList<String>();
		for ( int i=0; i < str.length(); ++i ) {
			list.add(String.valueOf(str.charAt(i)));
		}
		return list;
	}
}
