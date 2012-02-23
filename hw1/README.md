Homework 1
========== 

Run through a series of short coding problems to get warmed up with Java code, Collection classes and unit tests.

StringCode
---------- 

**String blowup(String str)**

Returns a version of the original string as follows: each digit 0-9 that appears in the original string is replaced by that many occurrences of the character to the right of the digit. So the string "a3tx2z" yields "attttxzzz" and "12x" yields "2xxx". A digit not followed by a character (i.e., at the end of the string) is replaced by nothing.

**int maxRun(String str)**

Given a string, returns the length of the largest run in the string. A "run" is a series of zero or more adjacent characters that are the same. So the max run of "xxyyyz" is 3, and the max run of "xyz" is 1.

**boolean stringIntersect(String a, String b, int len)**

Given two strings, consider all the substrings within them of length len. Returns true if there are any such substrings which appear in both strings. Compute this in O(n) time using a HashSet. Len will be 1 or more.

CharGrid
-------- 

The CharGrid class encapsulates a 2-d char array with a couple operations.

**int charArea(char ch)**

Given a char to look for, find the smallest rectangle that contains all the occurrences of that char and return the rectangle's area. If there is only a single occurrence of the char, then the rectangle to enclose it is [x] and the area is 1. If the character does not appear, return an area of 0. For example, given the grid:

<pre>
a b c d
a   c b
x b c a
</pre>

The area for 'a' is 12 (3 x 4) while for 'c' it is 3 (3 x 1). The second row contains a space bar, but that's still just a regular char.

For testing, you can set up a 2-d char[row][col] array literal like this (row 0 is "cax"):

<pre>
char[][] grid = new char[][] {
  {'c', 'a', 'x'},
  {'b', ' ', 'b'},
  {' ', ' ', 'a'}
};
</pre>

**int countPlus()**

Look for a '+' pattern in the grid made with repitition of a character. A + is made of a single character in the middle and four "arms" extending out up, down, left and right. The arms start with the middle char and extend until the first different character or grid edge. To count as a +, all the arms should have two or more chars and should all be the same length. For example, the grid below contains exactly 2 +'s:

<pre>
    p
    p         x
p p p p p   x x x
    p     y   x
    p   y y y 
z z z z z y z z z 
    x x   y
</pre>

TetrisGrid
---------- 

The TetrisGrid class encapsulates the classic rectangular board for the game Tetris (we'll play around with Tetris on Homework 2, so here's a chance to get a head start on that code). We'll store the Tetris board as a grid of booleans, where true is a filled square, and false is an empty square. We'll use the convention that grid[x][y] refers to a cell in the board game, with grid[0][0] representing the lower left square in the board, x growing to the right, y growing up (the standard Cartesian coordinate system). In the Tetris code, grid[x][y] is a natural way to think about the game, but notice that it's different from a grid[row][col] convention.

Constructor -- the TetrisGrid constructor should take in a boolean[][] grid argument. The width and height of the grid will both be at least one. For example, below is a grid that is width 2 and height 3. The 2-d array literal syntax is row/col oriented, so our grid[x][y] appears rotated 90 degrees clockwise.

<pre>
boolean[][] grid = new boolean[][] {
  { false, false, true },  // this is grid[x=0][..]
  { true, true, false }    // this is grid[x=1][..]
};
</pre>

**void clearRows()**

The one key method in TetrisGrid is clearRows() which should delete the full rows in the grid, shifting the rows above down and adding empty rows at the top, like this:

<pre>
-------         ------- 
| | | |         | | | | 
| | | |         | | | | 
|x| | |         | | | |
| |x|x|  ===>   | | | |
|x|x|x|         |x| | |
|x|x| |         | |x|x|
|x|x|x|         |x|x| |
-------         -------
</pre>

There is a simple getGrid() that exposes the grid stored in TetrisGrid, so unit tests can call clearRows() and then getGrid() to check the resulting grid.

Collections
----------- 

Exercise the basic functionality of Java Collections.

**<T> int sameCount(Collection<T> a, Collection<T> b)**

In the Appearances class, the static Appearances.sameCount() method takes in two collections -- A and B -- containing a generic <T> element type. Assume that the T elements implement equals() and hashCode() correctly, and so may be compared and hashed. The elements are in no particular order. Every element in A appears in A one or more times, using .equals() to compare elements for equality (the standard definition of equals() for java collections). Likewise every element in B appears one or more times, sameCount() counts the number of elements that appear in both collections the same number of times.

For example, with the collections {"a", "b", "a", "b", "c"} and {"c", "a", "a", "d", "b", "b", "b"} it returns 2, since the "a" and "c" appear the same number of times in both collections. Use hasing to compute the number of appearances efficiently.

**class Taboo&lt;T&gt;**

Most of the previous problems have been about single methods, but Taboo is a class. The Taboo class encapsulates a "rules" list such as {"a", "c", "a", "b"}. The rules define what objects should not follow other objects. In this case "c" should not follow "a", "a", should not follow "c", and "b" should not follow "a". The objects in the rules may be any type, but will not be null.

The Taboo noFollow(elem) method returns the set of elements which should not follow the given element according to the rules. So with the rules {"a", "c", "a", "b"} the noFollow("a") returns the Set {"c", "b"}, while noFollow() with an element not constrained in the rules, e.g., noFollow("x") returns the empty set (the utility method Collections.emptySet() returns a read-only empty set for convinience).

The reduce(List<T>) operation takes in a list, iterates over the list from start to end, and modifies the list by deleting the second element of any adjacent elements during the iteration that violate the rules. So for example, with the above rules, the collection {"a", "c", "b", "x", "c", "a"} is reduced to {"a", "x", "c"}. The elements in bold -- {"a", "c", "b", "x", "c", "a"} -- are deleted during the iteration since they violate a rule.