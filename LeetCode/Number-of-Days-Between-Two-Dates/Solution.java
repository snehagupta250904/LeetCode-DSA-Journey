1class Solution {
2    public int daysBetweenDates(String date1, String date2) {
3        return Math.abs(calcDays(date1) - calcDays(date2));
4    }
5
6    private boolean isLeapYear(int year) {
7        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
8    }
9
10    private int daysInMonth(int year, int month) {
11        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
12        days[1] += isLeapYear(year) ? 1 : 0;
13        return days[month - 1];
14    }
15
16    private int calcDays(String date) {
17        int year = Integer.parseInt(date.substring(0, 4));
18        int month = Integer.parseInt(date.substring(5, 7));
19        int day = Integer.parseInt(date.substring(8));
20        int days = 0;
21        for (int y = 1971; y < year; ++y) {
22            days += isLeapYear(y) ? 366 : 365;
23        }
24        for (int m = 1; m < month; ++m) {
25            days += daysInMonth(year, m);
26        }
27        days += day;
28        return days;
29    }
30}