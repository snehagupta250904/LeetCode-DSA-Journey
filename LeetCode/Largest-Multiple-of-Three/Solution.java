1class Solution {
2    public String largestMultipleOfThree(int[] digits) {
3        Arrays.sort(digits);
4        int n = digits.length;
5        int[][] f = new int[n + 1][3];
6        final int inf = 1 << 30;
7        for (var g : f) {
8            Arrays.fill(g, -inf);
9        }
10        f[0][0] = 0;
11        for (int i = 1; i <= n; ++i) {
12            for (int j = 0; j < 3; ++j) {
13                f[i][j] = Math.max(f[i - 1][j], f[i - 1][(j - digits[i - 1] % 3 + 3) % 3] + 1);
14            }
15        }
16        if (f[n][0] <= 0) {
17            return "";
18        }
19        StringBuilder sb = new StringBuilder();
20        for (int i = n, j = 0; i > 0; --i) {
21            int k = (j - digits[i - 1] % 3 + 3) % 3;
22            if (f[i - 1][k] + 1 == f[i][j]) {
23                sb.append(digits[i - 1]);
24                j = k;
25            }
26        }
27        int i = 0;
28        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
29            ++i;
30        }
31        return sb.substring(i);
32    }
33}