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

Given 2 strings, consider all the substrings within them of length len. Returns true if there are any such substrings which appear in both strings. Compute this in O(n) time using a HashSet. Len will be 1 or more.

CharGrid
-------- 

The CharGrid class encapsulates a 2d char array with a couple operations.

**int charArea(char ch)**

Given a char to look for, find the smallest rectangle that contains all the occurrences of that char and return the rectangle's area. If there is only a single occurrence of the char, then the rectangle to enclose it is [x] and the area is 1. If the character does not appear, return an area of 0. For example, given the grid:

<pre>
a b c d
a   c b
x b c a
</pre>

The area for 'a' is 12 (3 x 4) while for 'c' it is 3 (3 x 1). The second row contains a space bar, but that's still just a regular char.

For testing, you can set up a 2d char[row][col] array literal like this (row 0 is "cax"):

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

**void clearRows()**

The one key method in TetrisGrid is clearRows() which should delete the full rows in the grid, shifting the rows above down and adding empty rows at the top, like this:

[xx]

There is a simple getGrid() that exposes the grid stored in TetrisGrid, so unit tests can call clearRows() and then getGrid() to check the resulting grid.

xx