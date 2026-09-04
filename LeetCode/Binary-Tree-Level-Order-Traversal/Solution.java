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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> ans = new ArrayList<>();
19        if (root == null) {
20            return ans;
21        }
22        Deque<TreeNode> q = new ArrayDeque<>();
23        q.offer(root);
24        while (!q.isEmpty()) {
25            List<Integer> t = new ArrayList<>();
26            for (int n = q.size(); n > 0; --n) {
27                TreeNode node = q.poll();
28                t.add(node.val);
29                if (node.left != null) {
30                    q.offer(node.left);
31                }
32                if (node.right != null) {
33                    q.offer(node.right);
34                }
35            }
36            ans.add(t);
37        }
38        return ans;
39    }
40}