1class Solution {
2    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
3        List<List<Integer>> ans = new ArrayList<>();
4        if (root == null) {
5            return ans;
6        }
7        Deque<TreeNode> q = new ArrayDeque<>();
8        q.offer(root);
9        boolean left = true;
10        while (!q.isEmpty()) {
11            List<Integer> t = new ArrayList<>();
12            for (int n = q.size(); n > 0; --n) {
13                TreeNode node = q.poll();
14                t.add(node.val);
15                if (node.left != null) {
16                    q.offer(node.left);
17                }
18                if (node.right != null) {
19                    q.offer(node.right);
20                }
21            }
22            if (!left) {
23                Collections.reverse(t);
24            }
25            ans.add(t);
26            left = !left;
27        }
28        return ans;
29    }
30}