1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    private Integer prev;
18
19    public boolean isValidBST(TreeNode root) {
20          prev = null;
21        return dfs(root);
22    }
23
24    private boolean dfs(TreeNode root) {
25        if (root == null) {
26            return true;
27        }
28        if (!dfs(root.left)) {
29            return false;
30        }
31        if (prev != null && prev >= root.val) {
32            return false;
33        }
34        prev = root.val;
35        if (!dfs(root.right)) {
36            return false;
37        }
38        return true;
39    }
40}