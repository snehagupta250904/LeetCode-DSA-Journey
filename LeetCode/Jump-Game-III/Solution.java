1
2class Solution {
3    public boolean canReach(int[] arr, int start) {
4        int n = arr.length;
5
6        boolean[] visited = new boolean[n];
7        Queue<Integer> queue = new LinkedList<>();
8
9        queue.offer(start);
10        visited[start] = true;
11
12        while (!queue.isEmpty()) {
13            int index = queue.poll();
14
15            // Found value 0
16            if (arr[index] == 0) {
17                return true;
18            }
19
20            // Jump to right
21            int right = index + arr[index];
22
23            if (right < n && !visited[right]) {
24                visited[right] = true;
25                queue.offer(right);
26            }
27
28            // Jump to left
29            int left = index - arr[index];
30
31            if (left >= 0 && !visited[left]) {
32                visited[left] = true;
33                queue.offer(left);
34            }
35        }
36
37        return false;
38    }
39}