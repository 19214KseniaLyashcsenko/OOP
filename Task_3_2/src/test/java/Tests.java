import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class Tests{
    @Test
    public void Test1(){
        ArrayList<RecordBook.Rec> sem1 = new ArrayList<RecordBook.Rec>();
        sem1.add(new RecordBook.Rec("Введение в алгебру и анализ", 3));
        sem1.add(new RecordBook.Rec("Декларативное программирование", 4));
        sem1.add(new RecordBook.Rec("Императивное программирование",  4));
        sem1.add(new RecordBook.Rec("История",  5));
        sem1.add(new RecordBook.Rec("Основы культуры речи",5  ));
        sem1.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику",  4));
        ArrayList<RecordBook.Rec> sem2 = new ArrayList<RecordBook.Rec>();
        sem2.add(new RecordBook.Rec("Введение в алгебру и анализ", 4));
        sem2.add(new RecordBook.Rec("Декларативное программирование",4));
        sem2.add(new RecordBook.Rec("Императивное программирование",  4));
        sem2.add(new RecordBook.Rec("Иностранный язык",  4));
        sem2.add(new RecordBook.Rec("Цифровые платформы", 5));
        sem2.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику", 4));
        RecordBook book = new RecordBook(3, "Ксения", "Лященко");
        book.replaceSemester(1,sem1);
        book.replaceSemester(2,sem2);
        assertEquals(4.3, book.averageGrade(),1);
        assertEquals(false,book.isIncreaseGrant());
        assertEquals(false,book.isRedDiploma());
    }

    @Test
    public void Test2(){
        ArrayList<RecordBook.Rec> sem1 = new ArrayList<RecordBook.Rec>();
        sem1.add(new RecordBook.Rec("Введение в алгебру и анализ", 5 ));
        sem1.add(new RecordBook.Rec("Декларативное программирование",5  ));
        sem1.add(new RecordBook.Rec("Императивное программирование",  5));
        sem1.add(new RecordBook.Rec("История",  5));
        sem1.add(new RecordBook.Rec("Основы культуры речи",5  ));
        sem1.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику", 5));
        ArrayList<RecordBook.Rec> sem2 = new ArrayList<RecordBook.Rec>();
        sem2.add(new RecordBook.Rec("Введение в алгебру и анализ",  5));
        sem2.add(new RecordBook.Rec("Декларативное программирование",  5));
        sem2.add(new RecordBook.Rec("Императивное программирование",  5));
        sem2.add(new RecordBook.Rec("Иностранный язык",  5));
        sem2.add(new RecordBook.Rec("Цифровые платформы", 5 ));
        sem2.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику", 5 ));
        RecordBook book = new RecordBook(3, "Александр", "Забивной");
        book.replaceSemester(1,sem1);
        book.replaceSemester(2,sem2);
        assertEquals(5, book.averageGrade(),1);
        assertEquals(true,book.isIncreaseGrant());
        assertEquals(true,book.isRedDiploma());
    }

    @Test
    public void Test3(){
        ArrayList<RecordBook.Rec> sem1 = new ArrayList<RecordBook.Rec>();
        sem1.add(new RecordBook.Rec("Введение в алгебру и анализ", 5));
        sem1.add(new RecordBook.Rec("Декларативное программирование",5  ));
        sem1.add(new RecordBook.Rec("Императивное программирование", 5 ));
        sem1.add(new RecordBook.Rec("История",  5));
        sem1.add(new RecordBook.Rec("Основы культуры речи",5));
        sem1.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику",  5));
        ArrayList<RecordBook.Rec> sem2 = new ArrayList<RecordBook.Rec>();
        sem2.add(new RecordBook.Rec("Введение в алгебру и анализ",5));
        sem2.add(new RecordBook.Rec("Декларативное программирование",5));
        sem2.add(new RecordBook.Rec("Императивное программирование", 5));
        sem2.add(new RecordBook.Rec("Иностранный язык",  5));
        sem2.add(new RecordBook.Rec("Цифровые платформы", 5 ));
        sem2.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику", 5 ));
        RecordBook book = new RecordBook(3,"Ольга", "Мирная");
        book.qualifyingWork(3);
        book.replaceSemester(1,sem1);
        book.replaceSemester(2,sem2);
        assertEquals(5, book.averageGrade(),1);
        assertEquals(true,book.isIncreaseGrant());
        assertEquals(false,book.isRedDiploma());
    }

    @Test
    public void Test4(){
        ArrayList<RecordBook.Rec> sem1 = new ArrayList<RecordBook.Rec>();
        sem1.add(new RecordBook.Rec("Введение в алгебру и анализ",  5));
        sem1.add(new RecordBook.Rec("Декларативное программирование",5  ));
        sem1.add(new RecordBook.Rec("Императивное программирование",  5));
        sem1.add(new RecordBook.Rec("История",  5));
        sem1.add(new RecordBook.Rec("Основы культуры речи",5));
        sem1.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику",5));
        ArrayList<RecordBook.Rec> sem2 = new ArrayList<RecordBook.Rec>();
        sem2.add(new RecordBook.Rec("Введение в алгебру и анализ",5));
        sem2.add(new RecordBook.Rec("Декларативное программирование",5  ));
        sem2.add(new RecordBook.Rec("Императивное программирование",  5));
        sem2.add(new RecordBook.Rec("Иностранный язык",  5));
        sem2.add(new RecordBook.Rec("Цифровые платформы", 5 ));
        sem2.add(new RecordBook.Rec("Введение в дискретную математику и математическую логику",5  ));
        RecordBook book = new RecordBook(4,"Сергей", "Лютый");
        book.replaceSemester(1,sem1);
        book.replaceSemester(2,sem2);
        assertEquals(5, book.averageGrade(),1);
        book.addRecordToSemester(3,new RecordBook.Rec("Модели вычислений",4));
        book.addRecordToSemester(3,new RecordBook.Rec("ДУ и ТФКП0",  4));
        assertEquals(4.6, book.averageGrade(),1);
        book.addRecordToSemester(3,new RecordBook.Rec("ТВ и МС", 4));
        book.addRecordToSemester(3,new RecordBook.Rec("Операционные системы", 5));
        book.addRecordToSemester(3,new RecordBook.Rec("Введение в ИИ",5));
        assertEquals(4.8, book.averageGrade(),1);
        book.qualifyingWork( 5);
        assertEquals(true,book.isRedDiploma());
    }
}
