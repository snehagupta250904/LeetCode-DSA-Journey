1class Solution {
2    public String largestNumber(int[] nums) {
3        List<String> vs = new ArrayList<>();
4        for (int v : nums) {
5            vs.add(v + "");
6        }
7        vs.sort((a, b) -> (b + a).compareTo(a + b));
8        if ("0".equals(vs.get(0))) {
9            return "0";
10        }
11        return String.join("", vs);
12    }
13}
14