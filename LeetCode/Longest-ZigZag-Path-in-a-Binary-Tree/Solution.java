1class Solution {
2    private int ans;
3
4    public int longestZigZag(TreeNode root) {
5        dfs(root, 0, 0);
6        return ans;
7    }
8
9    private void dfs(TreeNode root, int l, int r) {
10        if (root == null) {
11            return;
12        }
13        ans = Math.max(ans, Math.max(l, r));
14        dfs(root.left, r + 1, 0);
15        dfs(root.right, 0, l + 1);
16    }
17}