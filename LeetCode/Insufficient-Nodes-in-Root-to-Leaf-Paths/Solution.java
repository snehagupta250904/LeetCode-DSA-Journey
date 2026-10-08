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
17    public TreeNode sufficientSubset(TreeNode root, int limit) {
18        if (root == null) {
19            return null;
20        }
21        limit -= root.val;
22        if (root.left == null && root.right == null) {
23            return limit > 0 ? null : root;
24        }
25        root.left = sufficientSubset(root.left, limit);
26        root.right = sufficientSubset(root.right, limit);
27        return root.left == null && root.right == null ? null : root;
28    }
29}