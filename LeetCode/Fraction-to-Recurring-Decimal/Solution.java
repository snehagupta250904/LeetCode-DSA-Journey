1class Solution {
2    public String fractionToDecimal(int numerator, int denominator) {
3        if (numerator == 0) {
4            return "0";
5        }
6        StringBuilder sb = new StringBuilder();
7        boolean neg = (numerator > 0) ^ (denominator > 0);
8        sb.append(neg ? "-" : "");
9        long num = Math.abs((long) numerator);
10        long d = Math.abs((long) denominator);
11        sb.append(num / d);
12        num %= d;
13        if (num == 0) {
14            return sb.toString();
15        }
16        sb.append(".");
17        Map<Long, Integer> mp = new HashMap<>();
18        while (num != 0) {
19            mp.put(num, sb.length());
20            num *= 10;
21            sb.append(num / d);
22            num %= d;
23            if (mp.containsKey(num)) {
24                int idx = mp.get(num);
25                sb.insert(idx, "(");
26                sb.append(")");
27                break;
28            }
29        }
30        return sb.toString();
31    }
32}