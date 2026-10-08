1class Solution {
2    public TreeNode recoverFromPreorder(String traversal) {
3        Stack<TreeNode> stack = new Stack<>();
4        int i = 0;
5
6        while (i < traversal.length()) {
7            int depth = 0;
8            while (i < traversal.length() && traversal.charAt(i) == '-') {
9                depth++;
10                i++;
11            }
12
13            int num = 0;
14            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
15                num = num * 10 + (traversal.charAt(i) - '0');
16                i++;
17            }
18
19            // Create the new node
20            TreeNode newNode = new TreeNode(num);
21
22            while (stack.size() > depth) {
23                stack.pop();
24            }
25            if (!stack.isEmpty()) {
26                if (stack.peek().left == null) {
27                    stack.peek().left = newNode;
28                } else {
29                    stack.peek().right = newNode;
30                }
31            }
32
33            stack.push(newNode);
34        }
35        return stack.isEmpty() ? null : stack.get(0);
36    }
37}