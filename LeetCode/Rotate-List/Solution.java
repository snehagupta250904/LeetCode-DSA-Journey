1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null) {
4            return head;
5        }
6        ListNode cur = head;
7        int n = 0;
8        for (; cur != null; cur = cur.next) {
9            n++;
10        }
11        k %= n;
12        if (k == 0) {
13            return head;
14        }
15        ListNode fast = head;
16        ListNode slow = head;
17        while (k-- > 0) {
18            fast = fast.next;
19        }
20        while (fast.next != null) {
21            fast = fast.next;
22            slow = slow.next;
23        }
24        ListNode ans = slow.next;
25        slow.next = null;
26        fast.next = head;
27        return ans;
28    }
29}