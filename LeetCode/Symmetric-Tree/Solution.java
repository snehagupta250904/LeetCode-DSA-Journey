1class Solution {
2    public boolean isSymmetric(TreeNode root) {
3        return dfs(root, root);
4    }
5
6    private boolean dfs(TreeNode root1, TreeNode root2) {
7        if (root1 == null && root2 == null) {
8            return true;
9        }
10        if (root1 == null || root2 == null || root1.val != root2.val) {
11            return false;
12        }
13        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
14    }
15}