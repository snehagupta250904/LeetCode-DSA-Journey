1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double h = 30 * hour + 0.5 * minutes;
4        double m = 6 * minutes;
5        double diff = Math.abs(h - m);
6        return Math.min(diff, 360 - diff);
7    }
8}