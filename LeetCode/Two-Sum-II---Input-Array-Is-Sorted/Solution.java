1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3
4        int left = 0;
5        int right = numbers.length - 1;
6
7        while (left < right) {
8
9            int sum = numbers[left] + numbers[right];
10
11            if (sum == target) {
12                return new int[]{left + 1, right + 1};
13            }
14
15            if (sum < target) {
16                left++;
17            } else {
18                right--;
19            }
20        }
21
22        return new int[]{-1, -1};
23    }
24}