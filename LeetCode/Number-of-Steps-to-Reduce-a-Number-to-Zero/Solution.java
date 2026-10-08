1class Solution {
2
3    public int numberOfSteps(int num) {
4        int ans = 0;
5        while (num != 0) {
6            num = (num & 1) == 1 ? num - 1 : num >> 1;
7            ++ans;
8        }
9        return ans;
10    }
11}