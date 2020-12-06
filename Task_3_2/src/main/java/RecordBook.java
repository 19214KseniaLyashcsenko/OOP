import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecordBook {

    private static ArrayList<String> arrSubjects = new ArrayList<String>(Collections.nCopies(100, ""));
    private static ArrayList<Integer> arrGrades = new ArrayList<Integer>(Collections.nCopies(100, 0));

    static int[] semester = new int[]{0, 0, 10, 20, 30, 40, 50, 60, 70};
    static String[] strSemester = new String[]{"","Семестр 1","Семестр 2","Семестр 3","Семестр 4","Семестр 5", "Семестр 6", "Семестр 7","Семестр 8"};
    static boolean isThree = false;
    static boolean[] isFiveInSem = new boolean[]{true,true,true,true,true,true,true,true,true};
    static int lastSem = 0;
    static int counter = 0;
    static int counterFive = 0;

    /**
     * adds the subject and its grade to the student's record
     * @param semester number of semester
     * @param subject examination subject
     * @param grade grade for the subject on the exam
     */
    public static void semesterAdd(String semester, String subject, int grade) {
        int i;
        if(Arrays.asList(strSemester).contains(semester)) {
            i = Arrays.asList(strSemester).indexOf(semester);
        }
        else throw new IllegalArgumentException("Semester entered incorrectly!!!");
        if(grade > 5 && grade < 1) throw new IllegalArgumentException("Grade entered incorrectly!!!");

        if (RecordBook.semester[i] < RecordBook.semester[i - 1]) RecordBook.semester[i] = RecordBook.semester[i - 1];
        arrSubjects.add(RecordBook.semester[i], subject);
        arrGrades.add(RecordBook.semester[i], grade);
        RecordBook.semester[i]++;
        counter++;
        if (grade == 3) isThree = true;
        if (grade == 5) counterFive++;
        else isFiveInSem[i] = false;
        if (lastSem < i) lastSem = i;
    }

    /**
     * calculates the arithmetic mean of all grades
     * @return
     */
    public static double averageGrade() {
        int sum = 0;
        for (int i = 0; i < arrGrades.size(); i++) {
            sum += (int) arrGrades.get(i);
        }
        double res;
        res = (double) sum / counter;
        return res;
    }

    /**
     * calculates whether it is possible to increase the scholarship
     * @return
     */
    public static boolean isIncreaseGrant() {
        if(lastSem != 1){
            if(isFiveInSem[lastSem] == true && isFiveInSem[lastSem - 1] == true) return true;
            return false;
        }
        else System.out.println("Для повышения стипендии нужно проучиться два семестра без троек");
        return false;
    }

    /**
     * calculates whether it is possible to get a red diploma
     * @return
     */
    public static boolean isRedDiploma(){
        if (lastSem != 8) System.out.println("Вам еще далеко до диплома)");
        if(((float)counterFive/counter * 100 >=75) && arrGrades.get(semester[8] - 1) == 5 && isThree == false) return true;
        return false;
    }

}



