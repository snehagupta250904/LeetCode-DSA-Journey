1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3         Arrays.sort(nums);
4        List<List<Integer>> ans = new ArrayList<>();
5        int n = nums.length;
6        for (int i = 0; i < n - 2 && nums[i] <= 0; ++i) {
7            if (i > 0 && nums[i] == nums[i - 1]) {
8                continue;
9            }
10            int j = i + 1, k = n - 1;
11            while (j < k) {
12                int x = nums[i] + nums[j] + nums[k];
13                if (x < 0) {
14                    ++j;
15                } else if (x > 0) {
16                    --k;
17                } else {
18                    ans.add(List.of(nums[i], nums[j++], nums[k--]));
19                    while (j < k && nums[j] == nums[j - 1]) {
20                        ++j;
21                    }
22                    while (j < k && nums[k] == nums[k + 1]) {
23                        --k;
24                    }
25                }
26            }
27        }
28        return ans;
29    }
30}