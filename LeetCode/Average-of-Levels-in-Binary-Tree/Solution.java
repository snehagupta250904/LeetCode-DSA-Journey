1class Solution {
2    private List<Long> s = new ArrayList<>();
3    private List<Integer> cnt = new ArrayList<>();
4
5    public List<Double> averageOfLevels(TreeNode root) {
6        dfs(root, 0);
7        List<Double> ans = new ArrayList<>();
8        for (int i = 0; i < s.size(); ++i) {
9            ans.add(s.get(i) * 1.0 / cnt.get(i));
10        }
11        return ans;
12    }
13
14    private void dfs(TreeNode root, int i) {
15        if (root == null) {
16            return;
17        }
18        if (s.size() == i) {
19            s.add((long) root.val);
20            cnt.add(1);
21        } else {
22            s.set(i, s.get(i) + root.val);
23            cnt.set(i, cnt.get(i) + 1);
24        }
25        dfs(root.left, i + 1);
26        dfs(root.right, i + 1);
27    }
28}
29