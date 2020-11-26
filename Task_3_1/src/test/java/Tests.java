import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void Test1(){
        MyDate date = new MyDate(26, "November", 2020);
        MyDate res;
        res = MyCalendar.plusDays(date, 1024);
        String dayOfWeek = MyCalendar.dayOfWeek(res);
        assertEquals(dayOfWeek,"Saturday");

    }

    @Test
    public void Test2() {
        MyDate date1 = new MyDate(26, "November", 2020);
        MyDate date2 = new MyDate(9, "May", 1945);
        int[] resArr;
        resArr = MyCalendar.minDate(date1, date2);
        int year = resArr[0];
        int month = resArr[1];
        int day = resArr[2];
        assertEquals(75, year);
        assertEquals(6, month);
        assertEquals(17,day);
    }

    @Test
    public void Test3() {
        MyDate date = new MyDate(6, "February", 2001);
        String res = MyCalendar.dayOfWeek(date);
        assertEquals("Tuesday", res);

        date = new MyDate(29, "February", 2020);
        res = MyCalendar.dayOfWeek(date);
        assertEquals("Saturday", res);
    }

    @Test
    public void Test4(){
        MyDate date = new MyDate(26, "November", 2020);
        MyDate res = MyCalendar.plusDays(date, 119);
        assertEquals(res.getMonth(), "March");
    }

}









