1class Solution {
2    public boolean isPowerOfFour(int n) {
3        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
4    }
5}