Homework 1
========== 

Run through a series of short coding problems to get warmed up with Java code, Collection classes and unit tests.

StringCode
---------- 

String blowup(String str)

Returns a version of the original string as follows: each digit 0-9 that appears in the original string is replaced by that many occurrences of the character to the right of the digit. So the string "a3tx2z" yields "attttxzzz" and "12x" yields "2xxx". A digit not followed by a character (i.e., at the end of the string) is replaced by nothing.

int maxRun(String str)

Given a string, returns the length of the largest run in the string. A "run" is a series of zero or more adjacent characters that are the same. So the max run of "xxyyyz" is 3, and the max run of "xyz" is 1.

boolean stringIntersect(String a, String b, int len)

Given 2 strings, consider all the substrings within them of length len. Returns true if there are any such substrings which appear in both strings. Compute this in O(n) time using a HashSet. Len will be 1 or more.

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