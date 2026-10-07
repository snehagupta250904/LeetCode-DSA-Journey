1class Solution {
2    public boolean isValidSerialization(String preorder) {
3        List<String> stk = new ArrayList<>();
4        for (String s : preorder.split(",")) {
5            stk.add(s);
6            while (stk.size() >= 3 && stk.get(stk.size() - 1).equals("#")
7                && stk.get(stk.size() - 2).equals("#") && !stk.get(stk.size() - 3).equals("#")) {
8                stk.remove(stk.size() - 1);
9                stk.remove(stk.size() - 1);
10                stk.remove(stk.size() - 1);
11                stk.add("#");
12            }
13        }
14        return stk.size() == 1 && stk.get(0).equals("#");
15    }
16}