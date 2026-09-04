1class Solution {
2    public int minimumPartition(String s, long k) {
3        int count = 0;
4        long num = 0;
5
6        for (char c : s.toCharArray()) {
7            int digit = c - '0';
8
9            // Single digit itself is greater than k
10            if (digit > k) return -1;
11
12            if (num * 10 + digit > k) {
13                count++;
14                num = digit;
15            } else {
16                num = num * 10 + digit;
17            }
18        }
19
20        return count + 1;
21    }
22}