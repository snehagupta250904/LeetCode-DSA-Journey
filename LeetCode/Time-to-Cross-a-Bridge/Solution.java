1class Solution {
2    public int findCrossingTime(int n, int k, int[][] time) {
3        int[][] t = new int[k][5];
4        for (int i = 0; i < k; ++i) {
5            int[] x = time[i];
6            t[i] = new int[] {x[0], x[1], x[2], x[3], i};
7        }
8        Arrays.sort(t, (a, b) -> {
9            int x = a[0] + a[2], y = b[0] + b[2];
10            return x == y ? a[4] - b[4] : x - y;
11        });
12        int cur = 0;
13        PriorityQueue<Integer> waitInLeft = new PriorityQueue<>((a, b) -> b - a);
14        PriorityQueue<Integer> waitInRight = new PriorityQueue<>((a, b) -> b - a);
15        PriorityQueue<int[]> workInLeft = new PriorityQueue<>((a, b) -> a[0] - b[0]);
16        PriorityQueue<int[]> workInRight = new PriorityQueue<>((a, b) -> a[0] - b[0]);
17        for (int i = 0; i < k; ++i) {
18            waitInLeft.offer(i);
19        }
20        while (true) {
21            while (!workInLeft.isEmpty()) {
22                int[] p = workInLeft.peek();
23                if (p[0] > cur) {
24                    break;
25                }
26                waitInLeft.offer(workInLeft.poll()[1]);
27            }
28            while (!workInRight.isEmpty()) {
29                int[] p = workInRight.peek();
30                if (p[0] > cur) {
31                    break;
32                }
33                waitInRight.offer(workInRight.poll()[1]);
34            }
35            boolean leftToGo = n > 0 && !waitInLeft.isEmpty();
36            boolean rightToGo = !waitInRight.isEmpty();
37            if (!leftToGo && !rightToGo) {
38                int nxt = 1 << 30;
39                if (!workInLeft.isEmpty()) {
40                    nxt = Math.min(nxt, workInLeft.peek()[0]);
41                }
42                if (!workInRight.isEmpty()) {
43                    nxt = Math.min(nxt, workInRight.peek()[0]);
44                }
45                cur = nxt;
46                continue;
47            }
48            if (rightToGo) {
49                int i = waitInRight.poll();
50                cur += t[i][2];
51                if (n == 0 && waitInRight.isEmpty() && workInRight.isEmpty()) {
52                    return cur;
53                }
54                workInLeft.offer(new int[] {cur + t[i][3], i});
55            } else {
56                int i = waitInLeft.poll();
57                cur += t[i][0];
58                --n;
59                workInRight.offer(new int[] {cur + t[i][1], i});
60            }
61        }
62    }
63}