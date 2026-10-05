1class Solution {
2    int[] dp;
3    int[] arr;
4    int d;
5
6    public int maxJumps(int[] arr, int d) {
7        this.arr = arr;
8        this.d = d;
9
10        int n = arr.length;
11        dp = new int[n];
12
13        int answer = 0;
14
15        for (int i = 0; i < n; i++) {
16            answer = Math.max(answer, dfs(i));
17        }
18
19        return answer;
20    }
21
22    private int dfs(int i) {
23        // Already calculated
24        if (dp[i] != 0) {
25            return dp[i];
26        }
27
28        dp[i] = 1; // At least the current index
29
30        // Jump to the right
31        for (int j = i + 1; j <= i + d && j < arr.length; j++) {
32
33            // Cannot jump further
34            if (arr[j] >= arr[i]) {
35                break;
36            }
37
38            dp[i] = Math.max(dp[i], 1 + dfs(j));
39        }
40
41        // Jump to the left
42        for (int j = i - 1; j >= i - d && j >= 0; j--) {
43
44            // Cannot jump further
45            if (arr[j] >= arr[i]) {
46                break;
47            }
48
49            dp[i] = Math.max(dp[i], 1 + dfs(j));
50        }
51
52        return dp[i];
53    }
54}