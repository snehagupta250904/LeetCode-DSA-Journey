1class Solution {
2    public int[] addNegabinary(int[] arr1, int[] arr2) {
3        int i = arr1.length - 1, j = arr2.length - 1;
4        List<Integer> ans = new ArrayList<>();
5        for (int c = 0; i >= 0 || j >= 0 || c != 0; --i, --j) {
6            int a = i < 0 ? 0 : arr1[i];
7            int b = j < 0 ? 0 : arr2[j];
8            int x = a + b + c;
9            c = 0;
10            if (x >= 2) {
11                x -= 2;
12                c -= 1;
13            } else if (x == -1) {
14                x = 1;
15                c += 1;
16            }
17            ans.add(x);
18        }
19        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
20            ans.remove(ans.size() - 1);
21        }
22        Collections.reverse(ans);
23        return ans.stream().mapToInt(x -> x).toArray();
24    }
25}