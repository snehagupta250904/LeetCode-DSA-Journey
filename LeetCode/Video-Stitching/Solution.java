1class Solution {
2    public int videoStitching(int[][] clips, int time) {
3
4        int count = 0;
5        int currentEnd = 0;
6        int farthest = 0;
7
8        while (currentEnd < time) {
9
10            for (int[] clip : clips) {
11                if (clip[0] <= currentEnd) {
12                    farthest = Math.max(farthest, clip[1]);
13                }
14            }
15
16            if (farthest == currentEnd) {
17                return -1;
18            }
19
20            count++;
21            currentEnd = farthest;
22        }
23
24        return count;
25    }
26}