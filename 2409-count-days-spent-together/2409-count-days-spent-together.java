
class Solution {

    int findbyDay(String date, int[] cumMonthDays) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        return cumMonthDays[month - 1] + day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int[] cumMonthDays = new int[13];

        // Number of days before each month
        for (int i = 1; i <= 12; i++) {
            cumMonthDays[i] = cumMonthDays[i - 1] + monthDays[i - 1];
        }

        int arriveAliceDay = findbyDay(arriveAlice, cumMonthDays);
        int leaveAliceDay = findbyDay(leaveAlice, cumMonthDays);
        int arriveBobDay = findbyDay(arriveBob, cumMonthDays);
        int leaveBobDay = findbyDay(leaveBob, cumMonthDays);

        int overlapDays =
            Math.min(leaveAliceDay, leaveBobDay)
            - Math.max(arriveAliceDay, arriveBobDay) + 1;

        return Math.max(0, overlapDays);
    }
}
