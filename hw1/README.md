Homework 1
========== 

StringCode
---------- 

String blowup(String str)

Returns a version of the original string as follows: each digit 0-9 that appears in the original string is replaced by that many occurrences of the character to the right of the digit. So the string "a3tx2z" yields "attttxzzz" and "12x" yields "2xxx". A digit not followed by a character (i.e., at the end of the string) is replaced by nothing.

CharGrid
-------- 

The CharGrid class encapsulates a 2d char array with a couple operations.

int charArea(char ch)

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