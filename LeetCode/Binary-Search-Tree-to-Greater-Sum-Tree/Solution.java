1class Solution {
2    public TreeNode bstToGst(TreeNode root) {
3        int s = 0;
4        TreeNode node = root;
5        while (root != null) {
6            if (root.right == null) {
7                s += root.val;
8                root.val = s;
9                root = root.left;
10            } else {
11                TreeNode next = root.right;
12                while (next.left != null && next.left != root) {
13                    next = next.left;
14                }
15                if (next.left == null) {
16                    next.left = root;
17                    root = root.right;
18                } else {
19                    s += root.val;
20                    root.val = s;
21                    next.left = null;
22                    root = root.left;
23                }
24            }
25        }
26        return node;
27    }
28}