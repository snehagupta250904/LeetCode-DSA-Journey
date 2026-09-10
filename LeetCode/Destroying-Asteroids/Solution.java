1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4
5        long m = mass;
6
7        for (int a : asteroids) {
8            if (m < a) return false;
9            m += a;
10        }
11
12        return true;
13    }
14}