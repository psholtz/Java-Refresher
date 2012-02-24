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
	
	@Test 
	public void testTaboo2() {
		 List<String> rules = new ArrayList<String>();
		 rules.add("a");
		 rules.add("b");
		 rules.add(null);
		 rules.add("c");
		 rules.add("d");
		 
		 Taboo<String> t = new Taboo<String>(rules);

		 Set<String> s1 = new HashSet<String>();
		 Set<String> s2 = new HashSet<String>();
		 Set<String> s3 = new HashSet<String>();
		 
		 s1.add("b");
		 s3.add("d");
		 
		 assertTrue(Arrays.deepEquals(s1.toArray(), t.noFollow("a").toArray()));
		 assertTrue(Arrays.deepEquals(s3.toArray(), t.noFollow("c").toArray()));
		 assertTrue(Arrays.deepEquals(s2.toArray(), t.noFollow("b").toArray()));
		 assertTrue(Arrays.deepEquals(s2.toArray(), t.noFollow("d").toArray()));
	}
	
	@Test
	public void testTaboo3() {
		List<String> rules = stringToList("acbxcxa");
		Taboo<String> t = new Taboo<String>(rules);
		
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		Set<String> s3 = new HashSet<String>();
		Set<String> s4 = new HashSet<String>();
		Set<String> s5 = new HashSet<String>();
		
		s1.add("c");
		s2.add("b");
		s2.add("x");
		s3.add("x");
		s4.add("c");
		s4.add("a");
		
		assertTrue(Arrays.deepEquals(s1.toArray(), t.noFollow("a").toArray()));
		assertTrue(Arrays.deepEquals(s2.toArray(), t.noFollow("c").toArray()));
		assertTrue(Arrays.deepEquals(s3.toArray(), t.noFollow("b").toArray()));
		assertTrue(Arrays.deepEquals(s4.toArray(), t.noFollow("x").toArray()));
		assertTrue(Arrays.deepEquals(s5.toArray(), t.noFollow("y").toArray()));
	}
	
	@Test
	public void testTaboo4() {
		List<String> rules = stringToList("acab");
		Taboo<String> t = new Taboo<String>(rules); 
		
		// reduce the set
		List<String> set = stringToList("acbxca");
		t.reduce(set);
		
		// generate the "answer"
		List<String> s1 = new ArrayList<String>();
		s1.add("a");
		s1.add("x");
		s1.add("c");
		
		// test the equality
		assertTrue(Arrays.deepEquals(s1.toArray(), set.toArray()));
	}
	
	@Test
	public void testTaboo5() {
		 List<String> rules = new ArrayList<String>();
		 rules.add("a");
		 rules.add("b");
		 rules.add(null);
		 rules.add("c");
		 rules.add("d");
		 
		 Taboo<String> t = new Taboo<String>(rules);
		 
		// reduce the set
		List<String> set1 = stringToList("acbxca");
	
		List<String> answer1 = new ArrayList<String>();
		answer1.add("a");
		answer1.add("c");
		answer1.add("b");
		answer1.add("x");
		answer1.add("c");
		answer1.add("a");
		
		// first set is not impacted by tis reduction
		t.reduce(set1); 
		assertTrue(Arrays.deepEquals(set1.toArray(), answer1.toArray()));
		
		// this one will remove the "b" and "d"
		List<String> set2 = stringToList("abcd");
		System.out.println(set2);
		t.reduce(set2);
		
		List<String> answer2 = new ArrayList<String>();
		answer2.add("a");
		answer2.add("c");
		assertTrue(Arrays.deepEquals(set2.toArray(), answer2.toArray()));
		
		// another test of the same rule
		List<String> set3 = stringToList("abbbcddda");
		t.reduce(set3);
		
		List<String> answer3 = new ArrayList<String>();
		answer3.add("a");
		answer3.add("c");
		answer3.add("a");
		
		assertTrue(Arrays.deepEquals(set3.toArray(), answer3.toArray()));
	}
	
	private List<String> stringToList(String str) {
		List<String> list = new ArrayList<String>();
		for ( int i=0; i < str.length(); ++i ) {
			list.add(String.valueOf(str.charAt(i)));
		}
		return list;
	}
}
