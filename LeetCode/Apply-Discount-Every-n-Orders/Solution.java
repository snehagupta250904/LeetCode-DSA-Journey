1class Cashier {
2    private int i;
3    private int n;
4    private int discount;
5    private Map<Integer, Integer> d = new HashMap<>();
6
7    public Cashier(int n, int discount, int[] products, int[] prices) {
8        this.n = n;
9        this.discount = discount;
10        for (int j = 0; j < products.length; ++j) {
11            d.put(products[j], prices[j]);
12        }
13    }
14
15    public double getBill(int[] product, int[] amount) {
16        int dis = (++i) % n == 0 ? discount : 0;
17        double ans = 0;
18        for (int j = 0; j < product.length; ++j) {
19            int p = product[j], a = amount[j];
20            int x = d.get(p) * a;
21            ans += x - (dis * x) / 100.0;
22        }
23        return ans;
24    }
25}