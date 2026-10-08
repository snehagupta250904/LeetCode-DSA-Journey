1class ProductOfNumbers {
2    private List<Integer> s = new ArrayList<>();
3
4    public ProductOfNumbers() {
5        s.add(1);
6    }
7
8    public void add(int num) {
9        if (num == 0) {
10            s.clear();
11            s.add(1);
12            return;
13        }
14        s.add(s.get(s.size() - 1) * num);
15    }
16
17    public int getProduct(int k) {
18        int n = s.size();
19        return n <= k ? 0 : s.get(n - 1) / s.get(n - k - 1);
20    }
21}