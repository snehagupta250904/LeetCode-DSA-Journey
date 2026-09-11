1class Solution {
2    public int minJumps(int[] arr) {
3        int n = arr.length;
4
5        if (n == 1) {
6            return 0;
7        }
8
9        // Store all indices having the same value
10        Map<Integer, List<Integer>> map = new HashMap<>();
11
12        for (int i = 0; i < n; i++) {
13            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
14        }
15
16        // BFS
17        Queue<Integer> queue = new LinkedList<>();
18        boolean[] visited = new boolean[n];
19
20        queue.offer(0);
21        visited[0] = true;
22
23        int steps = 0;
24
25        while (!queue.isEmpty()) {
26            int size = queue.size();
27
28            for (int s = 0; s < size; s++) {
29                int index = queue.poll();
30
31                // Reached last index
32                if (index == n - 1) {
33                    return steps;
34                }
35
36                // Jump to index + 1
37                int next = index + 1;
38
39                if (next < n && !visited[next]) {
40                    visited[next] = true;
41                    queue.offer(next);
42                }
43
44                // Jump to index - 1
45                next = index - 1;
46
47                if (next >= 0 && !visited[next]) {
48                    visited[next] = true;
49                    queue.offer(next);
50                }
51
52                // Jump to all indices with same value
53                List<Integer> sameValue = map.get(arr[index]);
54
55                if (sameValue != null) {
56                    for (int j : sameValue) {
57                        if (!visited[j]) {
58                            visited[j] = true;
59                            queue.offer(j);
60                        }
61                    }
62
63                    // Important:
64                    // We don't need this list again.
65                    map.remove(arr[index]);
66                }
67            }
68
69            steps++;
70        }
71
72        return -1;
73    }
74}