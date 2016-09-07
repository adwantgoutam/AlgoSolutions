/*
 * Given a string s and a string t, check if s is subsequence of t.

 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * 
 * Return true.
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * 
 * Return false.
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        boolean[] dp = new boolean[t.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < t.length(); ++j) {
                dp[j + 1] = dp[j + 1] || dp[j] || dp[j] && s.charAt(i) == t.charAt(j);
            }
        }
        return dp[t.length()];
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= t.length(); ++i) {
            dp[0][i] = true;
        }
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < t.length(); ++j) {
                dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i + 1][j] || dp[i][j] && s.charAt(i) == t.charAt(j);
            }
        }
        return dp[s.length()][t.length()];
    }

}