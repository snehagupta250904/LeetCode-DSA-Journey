1class Solution {
2    TreeNode first = null, second = null, prev = null;
3
4    public void recoverTree(TreeNode root) {
5        inorder(root);
6
7        // Swap the values
8        int temp = first.val;
9        first.val = second.val;
10        second.val = temp;
11    }
12
13    void inorder(TreeNode root) {
14        if (root == null) return;
15
16        inorder(root.left);
17
18        // Detect wrong order
19        if (prev != null && prev.val > root.val) {
20            if (first == null)
21                first = prev;
22            second = root;
23        }
24
25        prev = root;
26
27        inorder(root.right);
28    }
29}