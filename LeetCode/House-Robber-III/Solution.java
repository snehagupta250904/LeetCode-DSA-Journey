1class Solution {
2    private Map<TreeNode, Integer> memo;
3
4    public int rob(TreeNode root) {
5        memo = new HashMap<>();
6        return dfs(root);
7    }
8
9    private int dfs(TreeNode root) {
10        if (root == null) {
11            return 0;
12        }
13        if (memo.containsKey(root)) {
14            return memo.get(root);
15        }
16        int a = dfs(root.left) + dfs(root.right);
17        int b = root.val;
18        if (root.left != null) {
19            b += dfs(root.left.left) + dfs(root.left.right);
20        }
21        if (root.right != null) {
22            b += dfs(root.right.left) + dfs(root.right.right);
23        }
24        int res = Math.max(a, b);
25        memo.put(root, res);
26        return res;
27    }
28}