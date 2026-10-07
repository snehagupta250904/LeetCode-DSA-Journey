1class Solution {
2    public int compareVersion(String version1, String version2) {
3
4        String[] v1 = version1.split("\\.");
5        String[] v2 = version2.split("\\.");
6
7        int n = Math.max(v1.length, v2.length);
8
9        for (int i = 0; i < n; i++) {
10
11            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
12            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
13
14            if (num1 < num2) {
15                return -1;
16            }
17
18            if (num1 > num2) {
19                return 1;
20            }
21        }
22
23        return 0;
24    }
25}