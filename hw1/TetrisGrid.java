/**
 * Encapsulates logic for a Tetris grid board and 
 * implements clearRows() functionality. 
 * 
 * @author psholtz
 *
 */
public class TetrisGrid {

	// Private instance variable holding the grid structure.
	private boolean[][] grid;
	
	/**
	 * Initialize the tetris grid with a boolean double array. Bear in mind
	 * that the boolean double array is rotated 90-degrees clockwise from
	 * how the image would be rendered "graphically" in a real game. 
	 * 
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	/***
	 * Performs row-clearing on the grid by invoking the private, recursive row-clearing method below. 
	 */
	public void clearRows() {
		clearRowsFromRow(0);
	}
	
	/**
	 * Identify all rows, at "row" number or higher, which are in need
	 * of being cleared. If a row is identified, we (a) clear the row; 
	 * and (b) recursively re-invoke this method at that same row number
	 * to continue looking for rows to clear.
	 * 
	 * @param row Starting looking at this row number (and higher) for rows to clear. 
	 */
	private void clearRowsFromRow(int row) {
		for ( int y=0; y < grid[0].length; ++y ) {
			boolean shouldClear = true;
			for ( int x=0; x < grid.length; ++x ) {
				if ( !grid[x][y] ) {
					shouldClear = false;
				}
			}
			
			// clear this row (if necessary) and then recursively clear from same spot
			if ( shouldClear ) {
				collapseRowsFromRow(y);
				clearRowsFromRow(y);
			}
		}
	}
	
	/**
	 * Clear the row identified by the argument "row". All rows "above"
	 * the argument row are collapsed down by 1, and the argument "row"
	 * itself is removed. The "top" row is filled with "false" values.
	 * 
	 * @param row Integer identifying the row to be cleared.
	 */
	private void collapseRowsFromRow(int row) {
		for ( int y=row+1; y < grid[0].length; ++y ) {
			for ( int x=0; x < grid.length; ++x ) {
				grid[x][y-1] = grid[x][y];
			}
		}
		
		// clear the "top" row, setting to false 
		for ( int x=0; x < grid.length; ++x ) {
			grid[x][grid[0].length-1] = false;
		}
	}
	
	/***
	 * Public accessor for unit testing.
	 * 
	 * @return boolean[][] representing the grid (rotated clockwise through 90 degrees)
	 */
	public boolean[][] getGrid() {
		return grid; 
	}
	
	//
	// Display APIs
	// 
	// These APIs are helpful for getting a visual grasp on how the grid looks
	//
	public void display() {
		displayBar();
		displayGrid();
		displayBar();
	}
	
	private void displayBar() {
		for ( int i=0; i < grid.length; ++i ) {
			System.out.print( i < grid.length-1 ? "__" : "_\r\n" );
		}
	}
	
	private void displayGrid() {
		for ( int y=grid[0].length-1; y >= 0; --y ) {
			for ( int x=0; x < grid.length; ++x ) {
				System.out.print(grid[x][y] ? "x " : "  ");
			}
			System.out.println("");
		}
	}
}
