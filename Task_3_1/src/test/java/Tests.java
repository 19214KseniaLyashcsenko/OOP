import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void Test1(){
        MyDate date = new MyDate(26, "November", 2020);
        MyDate res;
        res =  MyDate.plusDays(date, 1024);
        String dayOfWeek =  MyDate.dayOfWeek(res);
        assertEquals(dayOfWeek,"Saturday");

    }

    @Test
    public void Test2() {
        MyDate date1 = new MyDate(26, "November", 2020);
        MyDate date2 = new MyDate(9, "May", 1945);
        System.out.printf("%d %s %d\n",date1.getYear(), date1.getMonth(), date1.getDay());
        //System.out.printf("%d %d %d\n",year2, month1, day1);
        int[] resArr;
        resArr =  MyDate.subtractDate(date1, date2);
        int year = resArr[0];
        int month = resArr[1];
        int day = resArr[2];
        System.out.printf("%d %d %d", year, month,day);
        assertEquals(75, year);
        assertEquals(6, month);
        assertEquals(17,day);
    }

    @Test
    public void Test3() {
        MyDate date = new MyDate(6, "February", 2001);
        String res =  MyDate.dayOfWeek(date);
        assertEquals("Tuesday", res);

        date = new MyDate(29, "February", 2020);
        res =  MyDate.dayOfWeek(date);
        assertEquals("Saturday", res);
    }

    @Test
    public void Test4(){
        MyDate date = new MyDate(26, "November", 2020);
        MyDate res =  MyDate.plusDays(date, 119);
        assertEquals(res.getMonth(), "March");
    }

}







