1class Solution {
2    public long maxScore(int[] nums1, int[] nums2, int k) {
3        int n = nums1.length;
4        int[][] nums = new int[n][2];
5        for (int i = 0; i < n; ++i) {
6            nums[i] = new int[] {nums1[i], nums2[i]};
7        }
8        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
9        long ans = 0, s = 0;
10        PriorityQueue<Integer> q = new PriorityQueue<>();
11        for (int i = 0; i < n; ++i) {
12            s += nums[i][0];
13            q.offer(nums[i][0]);
14            if (q.size() == k) {
15                ans = Math.max(ans, s * nums[i][1]);
16                s -= q.poll();
17            }
18        }
19        return ans;
20    }
21}