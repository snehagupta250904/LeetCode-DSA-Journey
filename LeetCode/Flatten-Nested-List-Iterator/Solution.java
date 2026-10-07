1import java.util.*;
2
3public class NestedIterator implements Iterator<Integer> {
4
5    private Stack<NestedInteger> stack = new Stack<>();
6
7    public NestedIterator(List<NestedInteger> nestedList) {
8
9        // Add in reverse order
10        for (int i = nestedList.size() - 1; i >= 0; i--) {
11            stack.push(nestedList.get(i));
12        }
13    }
14
15    @Override
16    public Integer next() {
17        return stack.pop().getInteger();
18    }
19
20    @Override
21    public boolean hasNext() {
22
23        while (!stack.isEmpty()) {
24
25            NestedInteger current = stack.peek();
26
27            // If current is an integer
28            if (current.isInteger()) {
29                return true;
30            }
31
32            // Remove the list
33            stack.pop();
34
35            // Add its elements in reverse order
36            List<NestedInteger> list = current.getList();
37
38            for (int i = list.size() - 1; i >= 0; i--) {
39                stack.push(list.get(i));
40            }
41        }
42
43        return false;
44    }
45}