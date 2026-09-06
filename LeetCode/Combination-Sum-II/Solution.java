1class Solution {
2    private List<List<Integer>> ans = new ArrayList<>();
3    private List<Integer> t = new ArrayList<>();
4    private int[] candidates;
5
6    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
7        Arrays.sort(candidates);
8        this.candidates = candidates;
9        dfs(0, target);
10        return ans;
11    }
12
13    private void dfs(int i, int s) {
14        if (s == 0) {
15            ans.add(new ArrayList<>(t));
16            return;
17        }
18        if (i >= candidates.length || s < candidates[i]) {
19            return;
20        }
21        for (int j = i; j < candidates.length; ++j) {
22            if (j > i && candidates[j] == candidates[j - 1]) {
23                continue;
24            }
25            t.add(candidates[j]);
26            dfs(j + 1, s - candidates[j]);
27            t.remove(t.size() - 1);
28        }
29    }
30}