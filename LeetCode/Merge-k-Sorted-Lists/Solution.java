1public class Merge_k_Sorted_Lists {
2
3    public static void main(String[] args) {
4
5        Merge_k_Sorted_Lists out = new Merge_k_Sorted_Lists();
6        Solution s = out.new Solution();
7
8        ListNode l1 = null;
9        ListNode l2 = new ListNode(1);
10
11        s.mergeKLists(new ListNode[]{l1, l2});
12
13    }
14
15    public class Solution {
16        public ListNode mergeKLists(ListNode[] lists) {
17
18            if (lists == null || lists.length == 0) {
19                return null;
20            }
21
22            // same as merge sort array
23            return merge(lists, 0, lists.length - 1);
24        }
25
26        public ListNode merge(ListNode[] lists, int start, int end) {
27
28            // single list
29            if (start == end) {
30                return lists[start];
31            }
32
33            int mid = (end - start) / 2 + start;
34            ListNode leftHalf = merge(lists, start, mid);
35            ListNode rightHalf = merge(lists, mid + 1, end);
36
37            return mergeTwoLists(leftHalf, rightHalf);
38        }
39
40        // from previous question: 21 Merge Two Sorted Lists
41        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
42
43            ListNode dummy = new ListNode(0);
44            ListNode current = dummy;
45
46            while (l1 != null || l2 != null) {
47                int v1 = (l1 == null ? Integer.MAX_VALUE : l1.val);
48                int v2 = (l2 == null ? Integer.MAX_VALUE : l2.val);
49
50                if (v1 < v2) {
51                    current.next = l1;
52                    l1 = l1.next;
53                } else {
54                    current.next = l2;
55                    l2 = l2.next;
56                }
57
58                current = current.next; // now current is the new end node, but still pointing to next node
59                current.next = null; // @note: key, cut this node from l1 or l2
60            }
61
62            return dummy.next;
63        }
64    }
65
66}
67
68//////
69
70class Solution_Heap {
71	public ListNode mergeKLists(ListNode[] lists) {
72
73		if (lists == null || lists.length == 0) {
74			return null;
75		}
76
77		ListNode dummy = new ListNode(0);
78		ListNode current = dummy;
79
80		// put 1st of each list to heap
81		PriorityQueue<ListNode> heap = new PriorityQueue<>(
82			(a,b) -> a.val - b.val
83		);
84
85		//
86		Arrays.stream(lists).filter(Objects::nonNull).forEach(heap::offer);
87
88		while (heap.size() != 0) {
89			ListNode polled = heap.poll();
90
91			current.next = polled;
92			current = current.next;
93
94			if (polled.next != null) {
95				heap.offer(polled.next); // @note: heap.offer()参数不能是null
96			}
97		}
98
99		return dummy.next;
100	}
101}
102
103//////
104
105/**
106 * Definition for singly-linked list.
107 * public class ListNode {
108 *     int val;
109 *     ListNode next;
110 *     ListNode() {}
111 *     ListNode(int val) { this.val = val; }
112 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
113 * }
114 */
115class Solution {
116    public ListNode mergeKLists(ListNode[] lists) {
117        int n = lists.length;
118        if (n == 0) {
119            return null;
120        }
121        for (int i = 0; i < n - 1; ++i) {
122            lists[i + 1] = mergeLists(lists[i], lists[i + 1]);
123        }
124        return lists[n - 1];
125    }
126
127    private ListNode mergeLists(ListNode l1, ListNode l2) {
128        ListNode dummy = new ListNode();
129        ListNode cur = dummy;
130        while (l1 != null && l2 != null) {
131            if (l1.val <= l2.val) {
132                cur.next = l1;
133                l1 = l1.next;
134            } else {
135                cur.next = l2;
136                l2 = l2.next;
137            }
138            cur = cur.next;
139        }
140        cur.next = l1 == null ? l2 : l1;
141        return dummy.next;
142    }
143}