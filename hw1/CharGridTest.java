import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CharGridTest {
	//
	// Char Area Tests
	//
	@Test
	public void testGridArea1() {
		char[][] grid = new char[][] {
				{ 'a', 'y', 'z' },
				{ 'x', 'a', 'z' },
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('x'));		
		assertEquals(1, cg.charArea('y'));
		assertEquals(2, cg.charArea('z'));
		assertEquals(0, cg.charArea(' '));
	}
	
	@Test
	public void testGridArea2() {
		char[][] grid = new char[][] {
				{ 'c', 'a', ' ' },
				{ 'b', ' ', 'b' },
				{ ' ', ' ', 'a' }
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(9, cg.charArea(' '));
		assertEquals(0, cg.charArea('x'));
	}
	
	@Test
	public void testGridArea3() {
		char[][] grid = new char[][] {
				{ 'a', 'b', 'c', 'd' },
				{ 'a', ' ', 'c', 'b' },
				{ 'x', 'b', 'c', 'a' }
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(12, cg.charArea('a'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(3, cg.charArea('c'));
		assertEquals(1, cg.charArea('d'));
		assertEquals(0, cg.charArea('e'));
		assertEquals(1, cg.charArea('x'));
	}
	
	@Test
	public void testGridArea4() {
		char[][] grid = new char[][] {
				{ 'c', 'a', 'x' },
				{ 'b', ' ', 'b' },
				{ ' ', ' ', 'a' }
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.charArea('d'));
		assertEquals(1, cg.charArea('x'));
		assertEquals(4, cg.charArea(' '));
	}
	
	@Test
	public void testGridArea5() {
		String s1 = "abca";
		String s2 = "axxx";
		char[][] grid = new char[][] {
			s1.toCharArray(),
			s2.toCharArray(),
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(8, cg.charArea('a'));
		assertEquals(1, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.charArea('d'));
		assertEquals(3, cg.charArea('x'));
	}
	
	@Test
	public void testGridArea6() {
		String s1 = "abca";
		String s2 = "axxx";
		String s3 = "qxxx";
		String s4 = "yyay";
		
		char[][] grid = new char[][] {
			s1.toCharArray(),
			s2.toCharArray(),
			s3.toCharArray(),
			s4.toCharArray()
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(16, cg.charArea('a'));
		assertEquals(1, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.charArea('d'));
		assertEquals(6, cg.charArea('x'));
	}

	// 
	// CountPlus Tests
	// 
	@Test
	public void testCountPlus1() {
		char[][] grid1 = new char[][] {
				{ 'x' }	
		};
		char[][] grid2 = new char[][] {
				{ 'a' },
				{ 'b' }
		};
		char[][] grid3 = new char[][] {
				{ 'a' },
				{ 'b' },
				{ 'c' }
		};
		char[][] grid4 = new char[][] {
				{ 'a' },
				{ 'b' },
				{ 'c' },
				{ 'd' }
		};
		char[][] grid5 = new char[][] {
				{ 'a', 'b', 'c' }
		};
		char[][] grid6 = new char[][] {
				{ 'a', 'b', 'c', 'd' }
		};
		
		CharGrid cg1 = new CharGrid(grid1);
		CharGrid cg2 = new CharGrid(grid2);
		CharGrid cg3 = new CharGrid(grid3);
		CharGrid cg4 = new CharGrid(grid4);
		CharGrid cg5 = new CharGrid(grid5);
		CharGrid cg6 = new CharGrid(grid6);
		
		assertEquals(0, cg1.countPlus());
		assertEquals(0, cg2.countPlus());
		assertEquals(0, cg3.countPlus());
		assertEquals(0, cg4.countPlus());
		assertEquals(0, cg5.countPlus());
		assertEquals(0, cg6.countPlus());
	}
	
	@Test
	public void testCountPlus2() {
		char[][] grid1 = new char[][] {
				{ 'x', 'y' },
		};
		char[][] grid2 = new char[][] {
				{ 'x', 'y' },
				{ 'a', 'b' },
		};
		char[][] grid3 = new char[][] {
				{ 'a', 'b' },
				{ 'c', 'd' },
				{ 'e', 'f' },
		};
		char[][] grid4 = new char[][] {
				{ 'a', 'b' },
				{ 'c', 'd' },
				{ 'e', 'f' },
				{ 'g', 'h' },
		};
		char[][] grid5 = new char[][] {
				{ 'a', 'b', 'c' },
				{ 'd', 'e', 'f' }
		};
		char[][] grid6 = new char[][] {
				{ 'a', 'b', 'c', 'd' },
				{ 'a', 'b', 'c', 'd' },
		};
		
		CharGrid cg1 = new CharGrid(grid1);
		CharGrid cg2 = new CharGrid(grid2);
		CharGrid cg3 = new CharGrid(grid3);
		CharGrid cg4 = new CharGrid(grid4);
		CharGrid cg5 = new CharGrid(grid5);
		CharGrid cg6 = new CharGrid(grid6);
		
		assertEquals(0, cg1.countPlus());
		assertEquals(0, cg2.countPlus());
		assertEquals(0, cg3.countPlus());
		assertEquals(0, cg4.countPlus());
		assertEquals(0, cg5.countPlus());
		assertEquals(0, cg6.countPlus());
	}
	
	@Test
	public void testCountPlus3() {
		char[][] grid1 = new char[][] { 
				{ ' ', 'x', ' '},
				{ 'x', 'x', 'x'},
				{ ' ', 'x', ' '}
		};
		char[][] grid2 = new char[][] {
				{ ' ', ' ', 'x', ' ', ' '},
				{ ' ', ' ', 'x', ' ', ' '},
				{ 'x', 'x', 'x', 'x', 'x'},
				{ ' ', ' ', 'x', ' ', ' '},
				{ ' ', ' ', 'x', ' ', ' '}
		};
		char[][] grid3 = new char[][] {
				{ ' ', ' ', 'x', ' ', ' '},
				{ ' ', ' ', 'x', ' ', ' '},
				{ 'x', 'x', 'x', 'x', 'x'},
				{ 'x', ' ', 'x', ' ', ' '},
				{ ' ', ' ', 'x', ' ', ' '}
		};
		char[][] grid4 = new char[][] {
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', 'x', 'x', 'x', 'x', 'x', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', 'x', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '}
		};
		char[][] grid5 = new char[][] {
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', 'x', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '}
		};
		char[][] grid6 = new char[][] {
				{ ' ', 't', ' ', 'x', ' ', ' ', ' '},
				{ 't', 't', 't', 'x', ' ', ' ', ' '},
				{ ' ', 't', ' ', 'x', ' ', ' ', ' '},
				{ 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', 'x', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '}	
		};
		char[][] grid7 = new char[][] {
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'}, 
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},			
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '},
		};
		char[][] grid8 = new char[][] { 
				{' ', ' ', 'p', ' ', ' ', 'q', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', 'q', 'q', 'q', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', 'q', 'x', 'x', 'x'}, 
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},			
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '},
		};
		
		CharGrid cg1 = new CharGrid(grid1);
		CharGrid cg2 = new CharGrid(grid2);
		CharGrid cg3 = new CharGrid(grid3);
		CharGrid cg4 = new CharGrid(grid4);
		CharGrid cg5 = new CharGrid(grid5);
		CharGrid cg6 = new CharGrid(grid6);
		CharGrid cg7 = new CharGrid(grid7);
		CharGrid cg8 = new CharGrid(grid8);
		
		assertEquals(1, cg1.countPlus());
		assertEquals(1, cg2.countPlus());
		assertEquals(0, cg3.countPlus());
		assertEquals(0, cg4.countPlus());
		assertEquals(1, cg5.countPlus());
		assertEquals(2, cg6.countPlus());
		assertEquals(2, cg7.countPlus());
		assertEquals(3, cg8.countPlus());
	}
}
