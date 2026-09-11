1class Solution {
2    public int totalNumbers(int[] digits) {
3        Set<Integer> s = new HashSet<>();
4        int n = digits.length;
5        for (int i = 0; i < n; ++i) {
6            if (digits[i] % 2 == 1) {
7                continue;
8            }
9            for (int j = 0; j < n; ++j) {
10                if (i == j) {
11                    continue;
12                }
13                for (int k = 0; k < n; ++k) {
14                    if (digits[k] == 0 || k == i || k == j) {
15                        continue;
16                    }
17                    s.add(digits[k] * 100 + digits[j] * 10 + digits[i]);
18                }
19            }
20        }
21        return s.size();
22    }
23}