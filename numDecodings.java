/** 
 * https://oj.leetcode.com/problems/decode-ways/ Decode Ways
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

  'A' -> 1
  'B' -> 2
  ...
  'Z' -> 26
  
  Given an encoded message containing digits, determine the total number of ways to decode it.
  
  For example,
  Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
  
  The number of ways decoding "12" is 2. 
*/
public class Solution {
    public int numDecodings(String s) {
       if(s==null||s.length()==0) return 0;
       int len = s.length();
       int[] nums = new int[len+1];
       nums[0] = 1;
       int num = 0;
       for(int i=1;i<=len;i++)
       {
           char currChar = s.charAt(i-1);
           if(currChar>'0') nums[i] = nums[i-1];
           if(i>1&& (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && currChar <= '6'))) nums[i] += nums[i-2];
       }
       return nums[len];
    }
}
