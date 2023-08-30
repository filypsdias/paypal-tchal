/*
Title: Length of the longest substring without repeating characters
Description: Given a string str, find the length of the longest substring without repeating characters.

Example:
- For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
- For “BBBB” the longest substring is “B”, with length 1.
- For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {

  //Maybe we can use Set here?
  //Iterate over string, verify if the next can be added. if not, start again
  public static int solution(String text) {
    Set<String> longestSubstring = new HashSet<>();
    int longestSize = 0;
    for (int i = 0; i < text.length(); i++) {
      String currentChar = String.valueOf(text.charAt(i));

      if (longestSubstring.contains(currentChar)) {
        if (longestSubstring.size() > longestSize) {
          longestSize = longestSubstring.size();
        }
          longestSubstring.clear();
      }

      longestSubstring.add(currentChar);
    }

    return longestSize;
  }

  public static void main(String[] args) {
    System.out.println(solution("ABDEFGABEF")); // 6
    System.out.println(solution("BBBB")); // 1
    System.out.println(solution("GEEKSFORGEEKS")); // 7
    System.out.println(solution("EKSFORGGEEEKS")); // 7
  }
}