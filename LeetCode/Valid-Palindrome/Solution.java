1class Solution {
2    public boolean isPalindrome(String s) {
3        int i = 0, j = s.length() - 1;
4        while (i < j) {
5            if (!Character.isLetterOrDigit(s.charAt(i))) {
6                ++i;
7            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
8                --j;
9            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
10                return false;
11            } else {
12                ++i;
13                --j;
14            }
15        }
16        return true;
17    }
18}