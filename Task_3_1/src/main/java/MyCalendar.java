import java.util.Arrays;

class MyDate {
    private static int[] dayInMonth = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] allMonth = new String[]{"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private  int day;
    private  String month;
    private  int year;

    MyDate(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
          if(Arrays.asList(allMonth).contains(month)) {
              int i = Arrays.asList(allMonth).indexOf(month);
              if (day <= dayInMonth[i] || (i == 2 && vesYear(year) && day <= 29))
                  return day;
              else throw new IllegalStateException("Days entered incorrectly!!!");
          }
          else throw new IllegalArgumentException("Month entered incorrectly!!!");
    }

    public String getMonth() {
        if(Arrays.asList(allMonth).contains(month))
        return month;
        else throw new IllegalArgumentException("Month entered incorrectly!!!");
    }

    public int getYear() {
        if(year>=1600 && year < 10000)
        return year;
        else throw new IllegalArgumentException("Years entered incorrectly!!!");
    }

    public int getIdMonth() {
        if(Arrays.asList(allMonth).contains(month))
            return Arrays.asList(allMonth).indexOf(month);
        else throw new IllegalArgumentException("Month entered incorrectly!!!");
    }

    public void printDate() {
        System.out.printf("%d %s %d\n", day, month, year);
    }


    /**
     *
     * @param date1 - date to deduct from
     * @param date2 - the date that is deducted
     * @return - return the result of subtracting date1 and date2 of type MyDate
     */
    public static int[] subtractDate(MyDate date1, MyDate date2){
        int day1 = date1.getDay();
        String strMonth1 = date1.getMonth();
        int month1 = date1.getIdMonth();
        int year1 = date1.getYear();
        System.out.printf("%d %d %d\n",year1, month1, day1);

        int day2 = date2.getDay();
        int month2 = date2.getIdMonth();
        int year2 = date2.getYear();
        System.out.printf("%d %d %d\n",year2, month2, day2);

        MyDate date = new MyDate(day1, strMonth1, year1);
        date = subtractDays(date1, day2);
        int day = date.getDay();

        date = date1;
        date = subtractMonth(date1, month2);

        int month = date.getIdMonth();
        int year =  year1 - year2;

        if(day1 == day2 && month1 == month2) month = 0;
        else {
            if (day1 < day2) month--;
            if (month1 <= month2) year--;
        }
        int[] resArr = new int[]{year,month,day};
        // System.out.printf("%d лет %d месяцев %d дней назад\n",year, month, day);
        return resArr;
    }

    /**
     *
     * @param date - date entered by user
     * @param countYear - the number of years to subtract
     * @return - returns the result of subtracting years to a date
     */
    public static MyDate subtractYear(MyDate date, int countYear){
        int day = date.getDay();
        String month = date.getMonth();
        int year = date.getYear();

        year-=countYear;
        MyDate newDate = new MyDate(day, month, year);
        return newDate;
    }

    /**
     *
     * @param date - date entered by user
     * @param countYear - the number of years to add
     * @return - returns the result of adding years to a date
     */
    public static MyDate plusYear(MyDate date, int countYear){
        int day = date.getDay();
        String month = date.getMonth();
        int year = date.getYear();

        year+=countYear;
        MyDate newDate = new MyDate(day, month, year);
        return newDate;
    }


    /**
     *
     * @param date - date entered by user
     * @param countMonth - the amount of month to subtract
     * @return - returns the result of subtracting month to a date
     */
    public static MyDate subtractMonth(MyDate date, int countMonth){
        int day = date.getDay();
        int month = date.getIdMonth();
        int year = date.getYear();


        for(int i = countMonth; i != 0; i--){
            month--;
            if(month == 0){
                month = 12;
                year--;
            }
        }

        String strMon = allMonth[month];
        MyDate newDate = new MyDate(day, strMon, year);
        return newDate;
    }

    /**
     *
     * @param date - date entered by user
     * @param countMonth - the amount of month to add
     * @return - returns the result of adding month to a date
     */
    public static MyDate plusMonth(MyDate date, int countMonth){
        int day = date.getDay();
        int month = date.getIdMonth();
        int year = date.getYear();


        for(int i = countMonth; i != 0; i--){
            month++;
            if(month == 13){
                month = 1;
                year++;
            }
        }

        String strMon = allMonth[month];
        MyDate newDate = new MyDate(day, strMon, year);
        return newDate;
    }

    /**
     *
     * @param date - date entered by user
     * @param day2 - the amount of days to subtract
     * @return - returns the result of subtracting amount of days to a date
     */
    public static MyDate subtractDays(MyDate date, int day2) {
        int day = date.getDay();
        int month = date.getIdMonth();
        int year = date.getYear();
        int daysInMonth;

        if (day > day2) {
            day -= day2;
        } else {
            if (month != 1) {
                daysInMonth = dayInMonth[--month];
                if (vesYear(year) && month == 2) daysInMonth++;
            } else {
                daysInMonth = 31;
                month = 12;
                year--;
            }
            while (day2 > 0) {

                if (day2 > daysInMonth) {
                    day2 -= daysInMonth;

                    if (month != 1) {
                        daysInMonth = dayInMonth[--month];
                        if (vesYear(year) && month == 2) daysInMonth++;
                    } else {
                        daysInMonth = 31;
                        month = 12;
                        year--;
                    }
                } else if (day2 > day) {
                    day2 -= day;
                    day = daysInMonth - day2;
                    day2 = 0;
                } else {
                    day -= day2;
                    day2 = 0;
                }
            }
        }
        String strMon = allMonth[month];
        MyDate newDate = new MyDate(day, strMon, year);
        return newDate;
    }

    /**
     *
     * @param date - date entered by user
     * @param day2 - the amount of days to add
     * @return - returns the result of adding the amount of days  to a date
     */
    public static MyDate plusDays(MyDate date, int day2) {
        int day = date.getDay();
        int month = date.getIdMonth();
        int year = date.getYear();

        int resDay = day + day2;
        int daysInMonth = dayInMonth[month];
        if (vesYear(year) && month == 2) daysInMonth++;

        while (resDay > dayInMonth[month]) {
            resDay -= daysInMonth;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
            daysInMonth = dayInMonth[month];
            if (vesYear(year) && month == 2) daysInMonth++;
        }
        String strMon = allMonth[month];
        MyDate newDate = new MyDate(resDay, strMon, year);
        return newDate;
    }

    /**
     *
     * @param date - date entered by user
     * @return - returns the day of the week of the given date
     */
    public static String dayOfWeek(MyDate date) {
        int day = date.getDay();
        int month = date.getIdMonth();
        int year = date.getYear();

        int numMounth = -1, numYear;
        switch (month) {
            case 1:
                numMounth = 1;
                break;
            case 2:
                numMounth = 4;
                break;
            case 3:
                numMounth = 4;
                break;
            case 4:
                numMounth = 0;
                break;
            case 5:
                numMounth = 2;
                break;
            case 6:
                numMounth = 5;
                break;
            case 7:
                numMounth = 0;
                break;
            case 8:
                numMounth = 3;
                break;
            case 9:
                numMounth = 6;
                break;
            case 10:
                numMounth = 1;
                break;
            case 11:
                numMounth = 4;
                break;
            case 12:
                numMounth = 6;
                break;
        }
        int idYear = 6, k = 6;
        int year2 = year / 100;
        for (int i = 16; i < 100; i++) {
            if (year2 == i) {
                idYear = k;
                break;
            }
            if (k == 0) k = 6;
            else k -= 2;
        }

        numYear = (idYear + (year % 100) + (year % 100) / 4) % 7;
        int numWeek = (day + numMounth + numYear) % 7;
        if (vesYear(year)) {
            if (month == 12 || month == 2) numWeek--;
            if (numWeek == -1) numWeek = 6;
        }
        String[] arrDayOfWeek = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String week = arrDayOfWeek[numWeek];
        return week;
    }

    /**
     *
     * @param year - year of date
     * @return - return true if the year is a leap year otherwise false
     */
    public static boolean vesYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0) return true;
        else return false;
    }
}
