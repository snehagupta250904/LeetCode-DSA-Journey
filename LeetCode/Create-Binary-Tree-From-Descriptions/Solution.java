1class Solution {
2    public TreeNode createBinaryTree(int[][] descriptions) {
3        HashMap<Integer, TreeNode> map = new HashMap<>();
4        HashSet<Integer> child = new HashSet<>();
5
6        for (int[] d : descriptions) {
7            int parent = d[0], c = d[1], isLeft = d[2];
8
9            map.putIfAbsent(parent, new TreeNode(parent));
10            map.putIfAbsent(c, new TreeNode(c));
11
12            if (isLeft == 1)
13                map.get(parent).left = map.get(c);
14            else
15                map.get(parent).right = map.get(c);
16
17            child.add(c);
18        }
19
20        for (int val : map.keySet()) {
21            if (!child.contains(val))
22                return map.get(val);
23        }
24
25        return null;
26    }
27}