1class Solution {
2    public String generateTheString(int n) {
3        return (n % 2 == 1) ? "a".repeat(n) : "a".repeat(n - 1) + "b";
4    }
5}