1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        int[] cnt = new int[26];
4        for (int i = 0; i < magazine.length(); ++i) {
5            ++cnt[magazine.charAt(i) - 'a'];
6        }
7        for (int i = 0; i < ransomNote.length(); ++i) {
8            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) {
9                return false;
10            }
11        }
12        return true;
13    }
14}