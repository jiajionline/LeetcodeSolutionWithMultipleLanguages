class Solution {
     public int daysBetweenDates(String date1, String date2) {
        int days1 = days(date1);
        int days2 = days(date2);
        return Math.abs(days1 - days2);
    }

    
    private int days(String d) {
        String[] ss = d.split("-");
        int year = Integer.valueOf(ss[0]);
        int month = Integer.valueOf(ss[1]);
        int day = Integer.valueOf(ss[2]);
        
        int ydelta = year - 1 - 1900;
        int dy = ydelta * 365 + ydelta / 4;// from 1900 every 4 years is leap year
       
        int[] monthOfDays = getMonthOfDays();
        int dm = monthOfDays[month - 1];
        if (isleap(year) && month-1 >= 2) {
            dm++;
        }
        return dy + dm + day;
    }

    private boolean isleap(int year) {
        return (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
    }
    
    private int[] getMonthOfDays() {
        
        int[] monthOfDays = new int[12];
        
        monthOfDays[0] = 0;
        monthOfDays[1] = 31;
        monthOfDays[2] = monthOfDays[1] + 28;
        monthOfDays[3] = monthOfDays[2] + 31;
        monthOfDays[4] = monthOfDays[3] + 30;
        monthOfDays[5] = monthOfDays[4] + 31;
        monthOfDays[6] = monthOfDays[5] + 30;
        monthOfDays[7] = monthOfDays[6] + 31;
        monthOfDays[8] = monthOfDays[7] + 31;
        monthOfDays[9] = monthOfDays[8] + 30;
        monthOfDays[10] = monthOfDays[9] + 31;
        monthOfDays[11] = monthOfDays[10] + 30;
        
        return monthOfDays;
    }

}
