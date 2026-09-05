1class Solution {
2    private Node prev, next;
3
4    public Node connect(Node root) {
5        Node node = root;
6        while (node != null) {
7            prev = null;
8            next = null;
9            while (node != null) {
10                modify(node.left);
11                modify(node.right);
12                node = node.next;
13            }
14            node = next;
15        }
16        return root;
17    }
18
19    private void modify(Node curr) {
20        if (curr == null) {
21            return;
22        }
23        if (next == null) {
24            next = curr;
25        }
26        if (prev != null) {
27            prev.next = curr;
28        }
29        prev = curr;
30    }
31}