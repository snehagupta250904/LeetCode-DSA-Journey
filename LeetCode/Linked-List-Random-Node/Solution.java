1class Solution {
2    private ListNode head;
3    private Random random = new Random();
4
5    public Solution(ListNode head) {
6        this.head = head;
7    }
8
9    public int getRandom() {
10        int ans = 0, n = 0;
11        for (ListNode node = head; node != null; node = node.next) {
12            ++n;
13            int x = 1 + random.nextInt(n);
14            if (n == x) {
15                ans = node.val;
16            }
17        }
18        return ans;
19    }
20}