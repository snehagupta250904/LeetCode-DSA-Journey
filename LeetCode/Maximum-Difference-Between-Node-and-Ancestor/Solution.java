1class Solution {
2    private int ans;
3
4    public int maxAncestorDiff(TreeNode root) {
5        dfs(root, root.val, root.val);
6        return ans;
7    }
8
9    private void dfs(TreeNode root, int mi, int mx) {
10        if (root == null) {
11            return;
12        }
13        int x = Math.max(Math.abs(mi - root.val), Math.abs(mx - root.val));
14        ans = Math.max(ans, x);
15        mi = Math.min(mi, root.val);
16        mx = Math.max(mx, root.val);
17        dfs(root.left, mi, mx);
18        dfs(root.right, mi, mx);
19    }
20}