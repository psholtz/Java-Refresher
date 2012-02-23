import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TetrisGridTest {
	@Test
	public void testTetrisGrid1() {
		String s1 = "x  ";
		String s2 = "x x";
		String s3 = "xxx";
		String s4 = " x ";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2),
			stringToBool(s3),
			stringToBool(s4)
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows(); 
		
		// grid should not change in this operation
		assertTrue( Arrays.deepEquals(grid, t.getGrid()) );
	}
	
	@Test
	public void testTetrisGrid2() {
		String s1 = "  x";
		String s2 = "xx ";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2),
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows();
		
		// grid should not change in this operation
		assertTrue( Arrays.deepEquals(grid, t.getGrid()) );
	}
	
	@Test
	public void testTetrisGrid3() {
		String s1 = "xxx x  ";
		String s2 = "xxxx   ";
		String s3 = "x xx   ";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2),
			stringToBool(s3),
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows();
		
		boolean[][] after = new boolean[][] {
				stringToBool("x x    "),
				stringToBool("xx     "),
				stringToBool(" x     "),
		};
		
		// grid changes
		assertTrue( Arrays.deepEquals(after, t.getGrid()) );
	}
	
	@Test
	public void testTetrisGrid4() {
		String s1 = "xx x ";
		String s2 = " xxx ";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2),
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows();
	
		boolean[][] after = new boolean[][] {
			stringToBool("x    "),
			stringToBool(" x   ")
		};
		
		// grid changes
		assertTrue( Arrays.deepEquals(after, t.getGrid()) );
	}
	
	@Test
	public void testTetrisGrid5() {
		String s1 = "xx x x";
		String s2 = " xxxxx";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2)
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows();

		// grid changes
		boolean[][] after = new boolean[][] {
				stringToBool("x     "),
				stringToBool(" xx   ")
		};
		assertTrue( Arrays.deepEquals(after, t.getGrid()) );
	}
	
	@Test
	public void testTetrisGrid6() {
		String s1 = "xx ";
		String s2 = "xxx";
		String s3 = " xx";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2),
			stringToBool(s2)
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows(); 
		
		boolean[][] after = new boolean[][] {
				stringToBool("   "),
				stringToBool("x  "),
				stringToBool("x  ")
		};
		assertTrue ( Arrays.deepEquals(after,t.getGrid()) );
	}
	
	@Test
	public void testTetrisGrid7() {
		String s1 = "xx ";
		String s2 = " xx";
		boolean[][] grid = new boolean[][] {
			stringToBool(s1),
			stringToBool(s2)
		};
		TetrisGrid t = new TetrisGrid(grid);
		t.clearRows();

		boolean[][] after = new boolean[][] {
				stringToBool("x  "),
				stringToBool(" x ")
		};
		assertTrue( Arrays.deepEquals(after, t.getGrid()) );
	}

	// helper utility method
	private boolean[] stringToBool(String str) {
		boolean[] array = new boolean[str.length()];
		for ( int i=0; i < str.length(); ++i ) {
			array[i] = str.charAt(i) == 'x' ? true : false;  
		}
		return array;
	}
}
