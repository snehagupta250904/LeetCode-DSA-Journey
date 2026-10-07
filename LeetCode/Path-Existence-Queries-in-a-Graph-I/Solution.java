1class Solution {
2    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        
4        // component[i] = component number of node i
5        int[] component = new int[n];
6        
7        int comp = 0;
8        component[0] = comp;
9
10        // Find connected components
11        for (int i = 1; i < n; i++) {
12            if (nums[i] - nums[i - 1] > maxDiff) {
13                comp++;
14            }
15            component[i] = comp;
16        }
17
18        // Answer queries
19        boolean[] answer = new boolean[queries.length];
20
21        for (int i = 0; i < queries.length; i++) {
22            int u = queries[i][0];
23            int v = queries[i][1];
24
25            answer[i] = component[u] == component[v];
26        }
27
28        return answer;
29    }
30}