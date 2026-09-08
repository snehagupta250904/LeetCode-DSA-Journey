1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[] arr = new int[m * n];
7        int index = 0;
8
9        // Convert grid into 1D array
10        for (int[] row : grid) {
11            for (int val : row) {
12                arr[index++] = val;
13            }
14        }
15
16        // Check if it is possible
17        int remainder = arr[0] % x;
18
19        for (int val : arr) {
20            if (val % x != remainder) {
21                return -1;
22            }
23        }
24
25        // Sort to find median
26        Arrays.sort(arr);
27
28        int median = arr[arr.length / 2];
29        int operations = 0;
30
31        // Calculate minimum operations
32        for (int val : arr) {
33            operations += Math.abs(val - median) / x;
34        }
35
36        return operations;
37    }
38}