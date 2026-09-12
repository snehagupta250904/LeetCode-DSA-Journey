1class Solution {
2    private int[] nums;
3    private int[] original;
4    private Random rand;
5
6    public Solution(int[] nums) {
7        this.nums = nums;
8        this.original = Arrays.copyOf(nums, nums.length);
9        this.rand = new Random();
10    }
11
12    public int[] reset() {
13        nums = Arrays.copyOf(original, original.length);
14        return nums;
15    }
16
17    public int[] shuffle() {
18        for (int i = 0; i < nums.length; ++i) {
19            swap(i, i + rand.nextInt(nums.length - i));
20        }
21        return nums;
22    }
23
24    private void swap(int i, int j) {
25        int t = nums[i];
26        nums[i] = nums[j];
27        nums[j] = t;
28    }
29}