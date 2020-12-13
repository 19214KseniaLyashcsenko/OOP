import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void Test1() {
        RecordBook RecordBook = new RecordBook("Ксения", "Лященко");
        RecordBook.semesterAdd(1, "Императивное программирование", 4);
        RecordBook.semesterAdd(1, "Введение в алгебру и анализ", 3);
        RecordBook.semesterAdd(1, "Введение в дискретную математику и математическую логику", 4);
        RecordBook.semesterAdd(1, "Основы культуры речи", 5);
        RecordBook.semesterAdd(1, "Декларативное программирование", 4);
        RecordBook.semesterAdd(1, "История", 5);

        RecordBook.semesterAdd(2, "Императивное программирование", 4);
        RecordBook.semesterAdd(2, "Цифровые платформы", 5);
        RecordBook.semesterAdd(2, "Введение в алгебру и анализ", 4);
        RecordBook.semesterAdd(2, "Иностранный язык", 4);
        RecordBook.semesterAdd(2, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(2, "Декларативное программирование", 4);
        RecordBook.semesterAdd(2, "Дипломная работа", 5);

        assertEquals(4.3, RecordBook.averageGrade(), 1);
        assertEquals(false,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }

    @Test
    public void Test2(){
        RecordBook RecordBook = new RecordBook("Анатолий", "Буравов");
        RecordBook.semesterAdd(1, "Императивное программирование", 5);
        RecordBook.semesterAdd(1, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(1, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(1, "Основы культуры речи", 5);
        RecordBook.semesterAdd(1, "Декларативное программирование", 5);
        RecordBook.semesterAdd(1, "История", 5);

        RecordBook.semesterAdd(2, "Императивное программирование", 5);
        RecordBook.semesterAdd(2, "Цифровые платформы", 5);
        RecordBook.semesterAdd(2, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(2, "Иностранный язык", 5);
        RecordBook.semesterAdd(2, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(2, "Декларативное программирование", 5);
        RecordBook.semesterAdd(2, "Дипломная работа", 5);

        assertEquals(5, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }

    @Test
    public void Test3(){
        RecordBook RecordBook = new RecordBook("Александр", "Забивной");
        RecordBook.semesterAdd(1, "Императивное программирование", 5);
        RecordBook.semesterAdd(1, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(1, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(1, "Основы культуры речи", 4);
        RecordBook.semesterAdd(1, "Декларативное программирование", 5);
        RecordBook.semesterAdd(1, "История", 5);

        RecordBook.semesterAdd(2, "Императивное программирование", 5);
        RecordBook.semesterAdd(2, "Цифровые платформы", 5);
        RecordBook.semesterAdd(2, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(2, "Иностранный язык", 4);
        RecordBook.semesterAdd(2, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(2, "Декларативное программирование", 5);
        RecordBook.semesterAdd(2, "Дипломная работа", 5);

        RecordBook.semesterAdd(3, "Введение в искусственный интеллект", 5);
        RecordBook.semesterAdd(3, "Модели вычислений", 5);

        RecordBook.semesterAdd(4, "Введение в компьютерные сети", 5);
        RecordBook.semesterAdd(4, "Программируемые микроконтроллеры", 5);

        RecordBook.semesterAdd(5, "Вычислительная математика", 4);
        RecordBook.semesterAdd(5, "Введение в разработку мобильных приложений",5 );

        RecordBook.semesterAdd(6, "Компьютерное моделирование",5 );
        RecordBook.semesterAdd(6, "Правоведение", 5);

        RecordBook.semesterAdd(7, "Инновационная экономика и технологическое предпринимательство",5 );
        RecordBook.semesterAdd(7, "Распределенные алгоритмы",5 );

        RecordBook.semesterAdd(8, "Основы риторики", 5);
        RecordBook.semesterAdd(8, "Дипломная работа", 5);

        assertEquals(4.8, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(true, RecordBook.isRedDiploma());
    }

    @Test
    public void Test4(){
        RecordBook RecordBook = new RecordBook("Ольга", "Мирная");
        RecordBook.semesterAdd(1, "Императивное программирование", 5);
        RecordBook.semesterAdd(1, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(1, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(1, "Основы культуры речи", 4);
        RecordBook.semesterAdd(1, "Декларативное программирование", 5);
        RecordBook.semesterAdd(1, "История", 5);

        RecordBook.semesterAdd(2, "Императивное программирование", 5);
        RecordBook.semesterAdd(2, "Цифровые платформы", 5);
        RecordBook.semesterAdd(2, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(2, "Иностранный язык", 4);
        RecordBook.semesterAdd(2, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(2, "Декларативное программирование", 5);
        RecordBook.semesterAdd(2, "Дипломная работа", 5);

        RecordBook.semesterAdd(3, "Введение в искусственный интеллект", 3);
        RecordBook.semesterAdd(3, "Модели вычислений", 5);

        RecordBook.semesterAdd(4, "Введение в компьютерные сети", 5);
        RecordBook.semesterAdd(4, "Программируемые микроконтроллеры", 5);

        RecordBook.semesterAdd(5, "Вычислительная математика", 4);
        RecordBook.semesterAdd(5, "Введение в разработку мобильных приложений",5 );

        RecordBook.semesterAdd(6, "Компьютерное моделирование",5 );
        RecordBook.semesterAdd(6, "Правоведение", 5);

        RecordBook.semesterAdd(7, "Инновационная экономика и технологическое предпринимательство",5 );
        RecordBook.semesterAdd(7, "Распределенные алгоритмы",5 );

        RecordBook.semesterAdd(8, "Основы риторики", 5);
        RecordBook.semesterAdd(8, "Дипломная работа", 5);

        assertEquals(4.8, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }

    @Test
    public void Test5(){
        RecordBook RecordBook = new RecordBook("Сергей", "Лютый");
        RecordBook.semesterAdd(1, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(1, "Основы культуры речи", 4);
        RecordBook.semesterAdd(8, "Основы риторики", 5);
        RecordBook.semesterAdd(7, "Распределенные алгоритмы",5 );
        RecordBook.semesterAdd(1, "Декларативное программирование", 5);
        RecordBook.semesterAdd(1, "История", 5);
        RecordBook.semesterAdd(2, "Императивное программирование", 5);
        RecordBook.semesterAdd(2, "Цифровые платформы", 5);
        RecordBook.semesterAdd(1, "Императивное программирование", 5);
        RecordBook.semesterAdd(1, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(2, "Введение в алгебру и анализ", 5);
        RecordBook.semesterAdd(6, "Компьютерное моделирование",5 );
        RecordBook.semesterAdd(2, "Иностранный язык", 4);
        RecordBook.semesterAdd(2, "Дипломная работа", 5);
        RecordBook.semesterAdd(8, "Дипломная работа", 5);
        RecordBook.semesterAdd(4, "Введение в компьютерные сети", 5);
        RecordBook.semesterAdd(4, "Программируемые микроконтроллеры", 5);
        RecordBook.semesterAdd(5, "Вычислительная математика", 4);
        RecordBook.semesterAdd(5, "Введение в разработку мобильных приложений",5 );
        RecordBook.semesterAdd(3, "Введение в искусственный интеллект", 3);
        RecordBook.semesterAdd(3, "Модели вычислений", 5);
        RecordBook.semesterAdd(6, "Правоведение", 5);
        RecordBook.semesterAdd(7, "Инновационная экономика и технологическое предпринимательство",5 );
        RecordBook.semesterAdd(2, "Введение в дискретную математику и математическую логику", 5);
        RecordBook.semesterAdd(2, "Декларативное программирование", 5);


        assertEquals(4.8, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }
}
