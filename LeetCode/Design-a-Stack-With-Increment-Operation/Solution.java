1class CustomStack {
2    private int[] stk;
3    private int[] add;
4    private int i;
5
6    public CustomStack(int maxSize) {
7        stk = new int[maxSize];
8        add = new int[maxSize];
9    }
10
11    public void push(int x) {
12        if (i < stk.length) {
13            stk[i++] = x;
14        }
15    }
16
17    public int pop() {
18        if (i <= 0) {
19            return -1;
20        }
21        int ans = stk[--i] + add[i];
22        if (i > 0) {
23            add[i - 1] += add[i];
24        }
25        add[i] = 0;
26        return ans;
27    }
28
29    public void increment(int k, int val) {
30        if (i > 0) {
31            add[Math.min(i, k) - 1] += val;
32        }
33    }
34}