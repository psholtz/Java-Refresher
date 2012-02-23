
import java.util.ArrayList;
import java.util.List;

/**
 * CharGrid encapsulates a 2D grid of chars and supports a few operations
 * on the grid. Methods include:
 * 
 * public int charArea(char ch);
 * public int countPlus();
 * 
 * @author psholtz
 *
 */
public class CharGrid {
	private char[][] grid;	 // private instance variable holding the grid
	
	/**
	 * Constructor for wrapping an object instance around a char[][]
	 * primitive, so that we can attach various methods to the object 
	 * instance. 
	 * 
	 * @param grid CharGrid class will provide a wrapper around the char[][] double array.
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Return the area for the given char in the grid. 
	 * Returns 0 if the given char does not appear in the grid. 
	 * 
	 * @param ch Character we are searching for.
	 * @return area Integer representing the area that the argument character covers in the grid.
	 */
	public int charArea(char ch) {
		// set the min and max column values just out of bounds
		int minX = grid[0].length + 1, maxX = -1;
		int minY = grid.length + 1, maxY = -1;
		int area = 0;
		boolean found = false;
		
		// step through the grid, outer loop by "y", inner loop by "x"
		for ( int y=0; y < grid.length; ++y ) {
			for ( int x=0; x < grid[y].length; ++x ) {
				if ( grid[y][x] == ch ) {
					// adjust the min and max values
					minX = minX < x ? minX : x;
					minY = minY < y ? minY : y;
					maxX = maxX > x ? maxX : x;
					maxY = maxY > y ? maxY : y;
					
					// signal that we found the character
					found = true;
				}
			}
		}
		
		// if we found the character, calculate the area
		if ( found ) {
			area = (maxY - minY + 1) * (maxX - minX + 1);
		}
		
		// return the answer 
		return area;
	}
	
	/**
	 * Look for a "+" pattern in the grid made with repetition of a 
	 * character. A + is made of single characters in the middle and 
	 * four "arms" extending out up, down, left and right. The arms 
	 * start with the middle char and extend until the first different
	 * character or grid edge. To count as a +, all the arms should have 
	 * two or more chars and should all be the same length.  
	 * 
	 * @return int Integer representing the number of "+" symbols in grid.
	 **/
	public int countPlus() {
		// we can only have crosses on grids of size 3x3 or bigger
		if ( grid.length < 3 || grid[0].length < 3 ) {
			return 0;
		}
		
		// we only need to count starting from margin of "1"
		int count = 0;
		for ( int y=1; y < grid.length-1; ++y ) {
			for ( int x=1; x < grid[0].length-1; ++x ) {
				count += isPlus(x,y) ? 1 : 0;
			}
		}
		return count;
	}
	
	/***
	 * The "radius" of a cross is the number of characters in one
	 * of its arms. The "radius" must be the same for all four arms.
	 * If the radius is 1 or greater, we have a cross.
	 * 
	 * @param x X-coordinate of the "center" of the potential plus sign.
	 * @param y Y-coordinate of the "center" of the potential plus sign. 
	 * @return boolean True if (x,y) really are at the centero of a plus sign, otherwise false. 
	 */
	private boolean isPlus(int x, int y) {
		// start testing to see if we have at least a radius of "1" 
		return radiusOfPlus(x, y, 1, grid[y][x]) > 0;
	}
	
	/**
	 * Recursive function to determine the radius of the potential 
	 * plus sign centered at (x,y). The symbol at the center point 
	 * (x,y) is "symbol", and when invoking this function, we are testing
	 * whether the argument "radius" is valid. If "yes", we recursively
	 * invoke the function to see if "radius+1" would be valid. 
	 * 
	 * Function returns the radius of the plus sign centered at (x,y)
	 * using the symbol "symbol". If there is no plus sign located
	 * at this point, function returns 0.
	 * 
	 * @param x X-coordinate of center point of potential plus sign.
	 * @param y Y-coordinate of center point of potential plus sign.
	 * @param radius Test to see if the potential plus sign has radius of at least "radius"
 	 * @param symbol Symbol located at the center point (x,y)
	 * @return int Integer representing radius of the plus sign centered at (x,y), composed of "symbol". Return 0 if there is no plus sign.
	 */
	private int radiusOfPlus(int x, int y, int radius, char symbol) {
		// Construct a collection of points to evaluate at this radius
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(x-radius,y));
		points.add(new Point(x+radius,y));
		points.add(new Point(x,y-radius));
		points.add(new Point(x,y+radius));
		
		// Find the points that are "inbounds" (i.e., not "outside" the grid)
		List<Point> innerPoints = removeOuterPoints(points);
		
		// If *all* the points are out-of-bounds, we must have plus symbol w/ arms of length "radius-1"
		if ( innerPoints.size() == 0 ) {
			 return radius - 1;
		}
		
		// If *all* of the points are in-bounds, run additional tests
		else if ( innerPoints.size() == points.size() ) {
			//
			// Test 1: make sure that all the "arm" points are consistent w/ center symbol
			//
			boolean good = true;
			for ( Point p : points ) {
				if ( !isSymbolConsistent(p,symbol) ) {
					good = false; 
				}
			}
			
			// 
			// Test 2: make sure all "boundary" points are inconsistent w/ center symbol
			//
			if ( good ) {
				// construct the list of boundary points 
				List<Point> boundaryPoints = new ArrayList<Point>();
				boundaryPoints.add(new Point(x-radius,y+1));
				boundaryPoints.add(new Point(x-radius,y-1));
				boundaryPoints.add(new Point(x+radius,y+1));
				boundaryPoints.add(new Point(x+radius,y-1));
				boundaryPoints.add(new Point(x+1,y-radius));
				boundaryPoints.add(new Point(x-1,y-radius));
				boundaryPoints.add(new Point(x+1,y+radius));
				boundaryPoints.add(new Point(x-1,y+radius));
				
				// we only care about the points that are in-bounds 
				boundaryPoints = removeOuterPoints(boundaryPoints);

				for ( Point p : boundaryPoints ) {
					if ( isSymbolConsistent(p,symbol) ) {
						good = false; 
					}
				}
			}
			
			//
			// If we are good, return next highest iteration, otherwise fail
			// 
			return good ? radiusOfPlus(x, y, radius+1, symbol) : 0;
		}
		
		else {
			// 
			// Test 3: make sure that the remaining inner points are inconsistent w/ center symbol
			//
			boolean good = true;
			for ( Point p : innerPoints ) {
				if ( isSymbolConsistent(p,symbol) ) {
					good = false; 
				}
			}
			return good ? radius - 1 : 0;
		}
	}
	
	/**
	 * Given a List of Points, remove all the points which are not 
	 * actually located in the grid. Return a list of Points, all of 
	 * which are "in-bounds", and located on the grid.
	 * 
	 * @param points Array of points, test each element and retain only if the point is actually on the grid.
	 * @return List<Point> Array of points, all of which are guaranteed to be located on the grid. 
	 */
	private List<Point> removeOuterPoints(List<Point> points) {
		List<Point> innerPoints = new ArrayList<Point>();
		for ( Point p : points ) {
			if ( !outOfBounds(p) ) {
				innerPoints.add(p);
			}
		}
		return innerPoints;
	}
	
	/**
	 * Is the Point p outside the bounds of the grid?
	 * 
	 * @param p Point to test, whether it is inside the grid or out.
	 * @return boolean True if Point p is inside the grid, otherwise false. 
	 */
	private boolean outOfBounds(Point p) {
		return p.x < 0 || p.x >= grid[0].length || p.y < 0 || p.y >= grid.length;
	}
	
	/**
	 * True if the symbol at Point p is "symbol", otherwise false.
	 * 
	 * @param p Point at which to test the symbol.
	 * @param symbol Symbol we are evaluating.
	 * @return boolean True if the symbol at Point p is "symbol", otherwise false.
	 */
	private boolean isSymbolConsistent(Point p, char symbol) {
		return grid[p.y][p.x] == symbol; 
	}
}

/**
 * Helper class that encapsulates an (x,y)-coordinate point.
 *  
 * @author psholtz
 *
 */
class Point {
	public int x;
	public int y;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() { return "(" + x + "," + y + ")"; }
}
