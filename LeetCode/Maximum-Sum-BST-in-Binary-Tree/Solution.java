1class Solution {
2    private int ans;
3    private final int inf = 1 << 30;
4
5    public int maxSumBST(TreeNode root) {
6        dfs(root);
7        return ans;
8    }
9
10    private int[] dfs(TreeNode root) {
11        if (root == null) {
12            return new int[] {1, inf, -inf, 0};
13        }
14        var l = dfs(root.left);
15        var r = dfs(root.right);
16        int v = root.val;
17        if (l[0] == 1 && r[0] == 1 && l[2] < v && r[1] > v) {
18            int s = v + l[3] + r[3];
19            ans = Math.max(ans, s);
20            return new int[] {1, Math.min(l[1], v), Math.max(r[2], v), s};
21        }
22        return new int[4];
23    }
24}