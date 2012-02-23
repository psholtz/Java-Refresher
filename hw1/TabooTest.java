import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TabooTest {
	@Test
	public void testTaboo1() {
		List<String> rules = stringToList("acab");
		Taboo<String> t = new Taboo<String>(rules);
		
		Set<String> s1 = new HashSet<String>();
		s1.add("b");
		s1.add("c");
		
		Set<String> s2 = new HashSet<String>();
		Set<String> s3 = new HashSet<String>();
		s3.add("a");
		
		assertTrue(Arrays.deepEquals(s1.toArray(), t.noFollow("a").toArray()));
		assertTrue(Arrays.deepEquals(s2.toArray(), t.noFollow("b").toArray()));
		assertTrue(Arrays.deepEquals(s3.toArray(), t.noFollow("c").toArray()));
	}
	
	private List<String> stringToList(String str) {
		List<String> list = new ArrayList<String>();
		for ( int i=0; i < str.length(); ++i ) {
			list.add(String.valueOf(str.charAt(i)));
		}
		return list;
	}
}
