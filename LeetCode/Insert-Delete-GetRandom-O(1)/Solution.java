1class RandomizedSet {
2    private Map<Integer, Integer> d = new HashMap<>();
3    private List<Integer> q = new ArrayList<>();
4    private Random rnd = new Random();
5
6    public RandomizedSet() {
7    }
8
9    public boolean insert(int val) {
10        if (d.containsKey(val)) {
11            return false;
12        }
13        d.put(val, q.size());
14        q.add(val);
15        return true;
16    }
17
18    public boolean remove(int val) {
19        if (!d.containsKey(val)) {
20            return false;
21        }
22        int i = d.get(val);
23        d.put(q.get(q.size() - 1), i);
24        q.set(i, q.get(q.size() - 1));
25        q.remove(q.size() - 1);
26        d.remove(val);
27        return true;
28    }
29
30    public int getRandom() {
31        return q.get(rnd.nextInt(q.size()));
32    }
33}