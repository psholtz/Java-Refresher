import static org.junit.Assert.*;

import org.junit.Test;

public class StringCodeTest {
	// 
	// Blowup Tests
	//
	@Test
	public void testBlowup1() {
		assertEquals("attttxzzz", StringCode.blowup("a3tx2z"));
		assertEquals("2xxx", StringCode.blowup("12x"));
	}
	
	@Test
	public void testBlowup2() {
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	@Test
	public void testBlowup3() {
		assertEquals("axxx", StringCode.blowup("a2x3"));
		assertEquals("a33111", StringCode.blowup("a231"));
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup4() {
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		assertEquals("", StringCode.blowup("2"));
		assertEquals("abc", StringCode.blowup("abc"));
		assertEquals("ABC", StringCode.blowup("ABC"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	// 
	// Run MaxRun Tests
	//
	@Test 
	public void testMaxRun1() {
		// test the corner cases
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(1, StringCode.maxRun("1"));
		assertEquals(1, StringCode.maxRun("a"));
		assertEquals(1, StringCode.maxRun("b"));
		assertEquals(1, StringCode.maxRun("c"));
	}
	
	@Test
	public void testMaxRun2() {
		assertEquals(2, StringCode.maxRun("xx"));
		assertEquals(3, StringCode.maxRun("xxx"));
		assertEquals(3, StringCode.maxRun("xxxa"));
		assertEquals(3, StringCode.maxRun("xxaaxxxbazc1"));
		assertEquals(3, StringCode.maxRun("xxxaxxx"));
	}
	
	@Test
	public void testMaxRun3() {
		assertEquals(3, StringCode.maxRun("xxyyyz"));
		assertEquals(1, StringCode.maxRun("xyz"));
	}
	
	@Test
	public void testMaxRun4() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testMaxRun5() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	@Test
	public void testMaxRun6() {
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	
	// 
	// Intersection Tests
	//
	@Test
	public void testIntersection1() {
		String s1 = "one";
		String s2 = "one two";
		
		assertEquals(true, StringCode.stringIntersect(s1,s2,1));
		assertEquals(true, StringCode.stringIntersect(s1,s2,2));
		assertEquals(true, StringCode.stringIntersect(s1,s2,3));
		assertEquals(false, StringCode.stringIntersect(s1,s2,4));
		assertEquals(false, StringCode.stringIntersect(s1,s2,5));
	}
	
	@Test
	public void testIntersection2() {
		String s1 = "this is my xxx";
		String s2 = "yxxx";
		
		assertEquals(true, StringCode.stringIntersect(s1,s2,1));
		assertEquals(true, StringCode.stringIntersect(s1,s2,2));
		assertEquals(true, StringCode.stringIntersect(s1,s2,3));
		assertEquals(false, StringCode.stringIntersect(s1,s2,4));
		assertEquals(false, StringCode.stringIntersect(s1,s2,5));
	}
	
	@Test
	public void testIntersection3()  {
		String s1 = "xxxthis is a test";
		String s2 = "now now nowxxx";
		
		assertEquals(true, StringCode.stringIntersect(s1,s2,1));
		assertEquals(true, StringCode.stringIntersect(s1,s2,2));
		assertEquals(true, StringCode.stringIntersect(s1,s2,3));
		assertEquals(false, StringCode.stringIntersect(s1,s2,4));
		assertEquals(false, StringCode.stringIntersect(s1,s2,5));
	}
	
	@Test
	public void testIntersection4() {
		String s1 = "The Tarantula Nebula in the Large Magellanic Cloud, a companion galaxy to the Milky Way, is called a nursery for new stars.";
		String s2 = "The growing awareness of plasma should make it also a nursery for new ideas to explain its features.";
	
		// the largest common substring will be " a nursery for new ", which contains 19 characters
		assertEquals(true,StringCode.stringIntersect(s1, s2, 19));
		assertEquals(false,StringCode.stringIntersect(s1, s2, 20));
	}
}
