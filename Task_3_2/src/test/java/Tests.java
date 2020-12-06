import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void Test1() {
        RecordBook.semesterAdd("������� 1", "������������ ����������������", 4);
        RecordBook.semesterAdd("������� 1", "�������� � ������� � ������", 3);
        RecordBook.semesterAdd("������� 1", "�������� � ���������� ���������� � �������������� ������", 4);
        RecordBook.semesterAdd("������� 1", "������ �������� ����", 5);
        RecordBook.semesterAdd("������� 1", "������������� ����������������", 4);
        RecordBook.semesterAdd("������� 1", "�������", 5);

        RecordBook.semesterAdd("������� 2", "������������ ����������������", 4);
        RecordBook.semesterAdd("������� 2", "�������� ���������", 5);
        RecordBook.semesterAdd("������� 2", "�������� � ������� � ������", 4);
        RecordBook.semesterAdd("������� 2", "����������� ����", 4);
        RecordBook.semesterAdd("������� 2", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 2", "������������� ����������������", 4);
        RecordBook.semesterAdd("������� 2", "��������� ������", 5);

        assertEquals(4.3, RecordBook.averageGrade(), 1);
        assertEquals(false,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }

    @Test
    public void Test2(){
        RecordBook.semesterAdd("������� 1", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 1", "������ �������� ����", 5);
        RecordBook.semesterAdd("������� 1", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������", 5);

        RecordBook.semesterAdd("������� 2", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 2", "�������� ���������", 5);
        RecordBook.semesterAdd("������� 2", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 2", "����������� ����", 5);
        RecordBook.semesterAdd("������� 2", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 2", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 2", "��������� ������", 5);

        assertEquals(5, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }

    @Test
    public void Test3(){
        RecordBook.semesterAdd("������� 1", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 1", "������ �������� ����", 4);
        RecordBook.semesterAdd("������� 1", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������", 5);

        RecordBook.semesterAdd("������� 2", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 2", "�������� ���������", 5);
        RecordBook.semesterAdd("������� 2", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 2", "����������� ����", 4);
        RecordBook.semesterAdd("������� 2", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 2", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 2", "��������� ������", 5);

        RecordBook.semesterAdd("������� 3", "�������� � ������������� ���������", 5);
        RecordBook.semesterAdd("������� 3", "������ ����������", 5);

        RecordBook.semesterAdd("������� 4", "�������� � ������������ ����", 5);
        RecordBook.semesterAdd("������� 4", "��������������� ����������������", 5);

        RecordBook.semesterAdd("������� 5", "�������������� ����������", 4);
        RecordBook.semesterAdd("������� 5", "�������� � ���������� ��������� ����������",5 );

        RecordBook.semesterAdd("������� 6", "������������ �������������",5 );
        RecordBook.semesterAdd("������� 6", "������������", 5);

        RecordBook.semesterAdd("������� 7", "������������� ��������� � ��������������� �������������������",5 );
        RecordBook.semesterAdd("������� 7", "�������������� ���������",5 );

        RecordBook.semesterAdd("������� 8", "������ ��������", 5);
        RecordBook.semesterAdd("������� 8", "��������� ������", 5);

        assertEquals(4.8, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(true, RecordBook.isRedDiploma());
    }

    @Test
    public void Test4(){
        RecordBook.semesterAdd("������� 1", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 1", "������ �������� ����", 4);
        RecordBook.semesterAdd("������� 1", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������", 5);

        RecordBook.semesterAdd("������� 2", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 2", "�������� ���������", 5);
        RecordBook.semesterAdd("������� 2", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 2", "����������� ����", 4);
        RecordBook.semesterAdd("������� 2", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 2", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 2", "��������� ������", 5);

        RecordBook.semesterAdd("������� 3", "�������� � ������������� ���������", 3);
        RecordBook.semesterAdd("������� 3", "������ ����������", 5);

        RecordBook.semesterAdd("������� 4", "�������� � ������������ ����", 5);
        RecordBook.semesterAdd("������� 4", "��������������� ����������������", 5);

        RecordBook.semesterAdd("������� 5", "�������������� ����������", 4);
        RecordBook.semesterAdd("������� 5", "�������� � ���������� ��������� ����������",5 );

        RecordBook.semesterAdd("������� 6", "������������ �������������",5 );
        RecordBook.semesterAdd("������� 6", "������������", 5);

        RecordBook.semesterAdd("������� 7", "������������� ��������� � ��������������� �������������������",5 );
        RecordBook.semesterAdd("������� 7", "�������������� ���������",5 );

        RecordBook.semesterAdd("������� 8", "������ ��������", 5);
        RecordBook.semesterAdd("������� 8", "��������� ������", 5);

        assertEquals(4.8, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }

    @Test
    public void Test5(){
        RecordBook.semesterAdd("������� 1", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 1", "������ �������� ����", 4);
        RecordBook.semesterAdd("������� 8", "������ ��������", 5);
        RecordBook.semesterAdd("������� 7", "�������������� ���������",5 );
        RecordBook.semesterAdd("������� 1", "������������� ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������", 5);
        RecordBook.semesterAdd("������� 2", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 2", "�������� ���������", 5);
        RecordBook.semesterAdd("������� 1", "������������ ����������������", 5);
        RecordBook.semesterAdd("������� 1", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 2", "�������� � ������� � ������", 5);
        RecordBook.semesterAdd("������� 6", "������������ �������������",5 );
        RecordBook.semesterAdd("������� 2", "����������� ����", 4);
        RecordBook.semesterAdd("������� 2", "��������� ������", 5);
        RecordBook.semesterAdd("������� 8", "��������� ������", 5);
        RecordBook.semesterAdd("������� 4", "�������� � ������������ ����", 5);
        RecordBook.semesterAdd("������� 4", "��������������� ����������������", 5);
        RecordBook.semesterAdd("������� 5", "�������������� ����������", 4);
        RecordBook.semesterAdd("������� 5", "�������� � ���������� ��������� ����������",5 );
        RecordBook.semesterAdd("������� 3", "�������� � ������������� ���������", 3);
        RecordBook.semesterAdd("������� 3", "������ ����������", 5);
        RecordBook.semesterAdd("������� 6", "������������", 5);
        RecordBook.semesterAdd("������� 7", "������������� ��������� � ��������������� �������������������",5 );
        RecordBook.semesterAdd("������� 2", "�������� � ���������� ���������� � �������������� ������", 5);
        RecordBook.semesterAdd("������� 2", "������������� ����������������", 5);


        assertEquals(4.8, RecordBook.averageGrade(), 1);
        assertEquals(true,RecordBook.isIncreaseGrant());
        assertEquals(false, RecordBook.isRedDiploma());
    }
}
