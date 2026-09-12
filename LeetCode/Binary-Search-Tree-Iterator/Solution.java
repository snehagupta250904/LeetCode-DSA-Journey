1public class BSTIterator {
2
3    private Stack<TreeNode> stack = new Stack<>();
4
5    public BSTIterator(TreeNode root) {
6        pushLeft(root);
7    }
8
9    // Push all left nodes into the stack
10    private void pushLeft(TreeNode node) {
11        while (node != null) {
12            stack.push(node);
13            node = node.left;
14        }
15    }
16
17    public int next() {
18        TreeNode node = stack.pop();
19
20        // After visiting a node, process its right subtree
21        if (node.right != null) {
22            pushLeft(node.right);
23        }
24
25        return node.val;
26    }
27
28    public boolean hasNext() {
29        return !stack.isEmpty();
30    }
31}