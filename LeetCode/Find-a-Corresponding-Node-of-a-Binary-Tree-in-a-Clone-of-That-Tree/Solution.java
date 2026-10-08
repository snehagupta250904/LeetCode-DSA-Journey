1class Solution {
2    private TreeNode target;
3
4    public final TreeNode getTargetCopy(
5        final TreeNode original, final TreeNode cloned, final TreeNode target) {
6        this.target = target;
7        return dfs(original, cloned);
8    }
9
10    private TreeNode dfs(TreeNode root1, TreeNode root2) {
11        if (root1 == null) {
12            return null;
13        }
14        if (root1 == target) {
15            return root2;
16        }
17        TreeNode res = dfs(root1.left, root2.left);
18        return res == null ? dfs(root1.right, root2.right) : res;
19    }
20}