1public class Same_Tree {
2
3    /**
4     * Definition for a binary tree node.
5     * public class TreeNode {
6     * int val;
7     * TreeNode left;
8     * TreeNode right;
9     * TreeNode(int x) { val = x; }
10     * }
11     */
12
13    public class Solution_iteration {
14        public boolean isSameTree(TreeNode p, TreeNode q) {
15            if (p == null) {
16                return q == null;
17            }
18
19            if (q == null) {
20                return p == null;
21            }
22
23            Stack<TreeNode> sk1 = new Stack<TreeNode>();
24            Stack<TreeNode> sk2 = new Stack<TreeNode>();
25
26            sk1.push(p);
27            sk2.push(q);
28
29            while (!sk1.isEmpty() && !sk2.isEmpty()) {
30                TreeNode current1 = sk1.pop();
31                TreeNode current2 = sk2.pop();
32
33                if (current1 == null && current2 == null) {
34                    continue; // @note: missed both null check
35                } else if (current1 == null && current2 != null) {
36                    return false;
37                } else if (current1 != null && current2 == null) {
38                    return false;
39                } else if (current1.val != current2.val) {
40                    return false;
41                }
42
43                sk1.push(current1.left);
44                sk2.push(current2.left);
45
46                sk1.push(current1.right);
47                sk2.push(current2.right);
48
49            }
50
51            // final check
52            if (!sk1.isEmpty() || !sk2.isEmpty()) {
53                return false;
54            }
55
56            return true;
57
58        }
59    }
60
61
62    public class Solution_recursion {
63        public boolean isSameTree(TreeNode p, TreeNode q) {
64
65            if (p == null) {
66                return q == null;
67            }
68
69            if (q == null) {
70                return p == null;
71            }
72
73            if (p.val != q.val) {
74                return false;
75            }
76
77            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
78        }
79    }
80
81}
82
83//////
84
85class Solution {
86    public boolean isSameTree(TreeNode p, TreeNode q) {
87        if (p == q) return true;
88        if (p == null || q == null || p.val != q.val) return false;
89        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
90    }
91}