1class Solution {
2    public int countNumbersWithUniqueDigits(int n) {
3
4        if (n == 0) {
5            return 1;
6        }
7
8        int count = 10;
9        int unique = 9;
10        int available = 9;
11
12        for (int digits = 2; digits <= n; digits++) {
13
14            unique = unique * available;
15            count += unique;
16
17            available--;
18        }
19
20        return count;
21    }
22}