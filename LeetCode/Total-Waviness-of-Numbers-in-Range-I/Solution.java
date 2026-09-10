1class Solution {
2    public int totalWaviness(int num1, int num2) {
3        int ans = 0;
4        for (int x = num1; x <= num2; x++) {
5            ans += f(x);
6        }
7        return ans;
8    }
9
10    private int f(int x) {
11        int[] nums = new int[20];
12        int m = 0;
13        while (x > 0) {
14            nums[m++] = x % 10;
15            x /= 10;
16        }
17        if (m < 3) {
18            return 0;
19        }
20        int s = 0;
21        for (int i = 1; i < m - 1; i++) {
22            if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
23                || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
24                s++;
25            }
26        }
27        return s;
28    }
29}
30