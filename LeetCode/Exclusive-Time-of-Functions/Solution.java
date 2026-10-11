1class Solution {
2    public int[] exclusiveTime(int n, List<String> logs) {
3        int[] ans = new int[n];
4        Deque<Integer> stk = new ArrayDeque<>();
5        int curr = -1;
6        for (String log : logs) {
7            String[] t = log.split(":");
8            int fid = Integer.parseInt(t[0]);
9            int ts = Integer.parseInt(t[2]);
10            if ("start".equals(t[1])) {
11                if (!stk.isEmpty()) {
12                    ans[stk.peek()] += ts - curr;
13                }
14                stk.push(fid);
15                curr = ts;
16            } else {
17                fid = stk.pop();
18                ans[fid] += ts - curr + 1;
19                curr = ts + 1;
20            }
21        }
22        return ans;
23    }
24}