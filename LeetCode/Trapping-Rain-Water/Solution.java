1class Solution {
2    public int trap(int[] height) {
3        int left = 0, right = height.length - 1;
4        int leftMax = 0, rightMax = 0;
5        int water = 0;
6
7        while (left < right) {
8            if (height[left] <= height[right]) {
9                if (height[left] >= leftMax)
10                    leftMax = height[left];
11                else
12                    water += leftMax - height[left];
13
14                left++;
15            } else {
16                if (height[right] >= rightMax)
17                    rightMax = height[right];
18                else
19                    water += rightMax - height[right];
20
21                right--;
22            }
23        }
24
25        return water;
26    }
27}