1class Solution {
2public:
3    long long maxPower(vector<int>& stations, int r, int k) {
4        int n = stations.size();
5        long d[n + 1];
6        memset(d, 0, sizeof d);
7        for (int i = 0; i < n; ++i) {
8            int left = max(0, i - r), right = min(i + r, n - 1);
9            d[left] += stations[i];
10            d[right + 1] -= stations[i];
11        }
12        long s[n + 1];
13        s[0] = d[0];
14        for (int i = 1; i < n + 1; ++i) {
15            s[i] = s[i - 1] + d[i];
16        }
17        auto check = [&](long x, int k) {
18            memset(d, 0, sizeof d);
19            long t = 0;
20            for (int i = 0; i < n; ++i) {
21                t += d[i];
22                long dist = x - (s[i] + t);
23                if (dist > 0) {
24                    if (k < dist) {
25                        return false;
26                    }
27                    k -= dist;
28                    int j = min(i + r, n - 1);
29                    int left = max(0, j - r), right = min(j + r, n - 1);
30                    d[left] += dist;
31                    d[right + 1] -= dist;
32                    t += dist;
33                }
34            }
35            return true;
36        };
37        long left = 0, right = 1e12;
38        while (left < right) {
39            long mid = (left + right + 1) >> 1;
40            if (check(mid, k)) {
41                left = mid;
42            } else {
43                right = mid - 1;
44            }
45        }
46        return left;
47    }
48};