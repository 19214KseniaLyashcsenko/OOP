import java.util.ArrayList;
import java.util.Collections;

public class RecordBook {

    private  ArrayList<String> arrSubjects = new ArrayList<String>(Collections.nCopies(100, ""));
    private  ArrayList<Integer> arrGrades = new ArrayList<Integer>(Collections.nCopies(100, 0));

    private  int[] semester = new int[]{0, 0, 10, 20, 30, 40, 50, 60, 70};
    private  boolean isThree = false;
    private  boolean[] isFiveInSem = new boolean[]{true,true,true,true,true,true,true,true,true};
    private  int lastSem = 0;
    private  int counter = 0;
    private  int counterFive = 0;

    private String name;
    private String surname;

    RecordBook(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * adds the subject and its grade to the student's record
     * @param numSemester number of semester
     * @param subject examination subject
     * @param grade grade for the subject on the exam
     */
    public  void semesterAdd(int numSemester, String subject, int grade) { ;
        if(numSemester > 8 || numSemester < 1) {
            throw new IllegalArgumentException("Semester entered incorrectly!!!");
        }
        if(grade > 5 && grade < 1) throw new IllegalArgumentException("Grade entered incorrectly!!!");

        if (semester[numSemester] < semester[numSemester - 1]) semester[numSemester] = semester[numSemester - 1];
        arrSubjects.add(semester[numSemester], subject);
        arrGrades.add(semester[numSemester], grade);
        semester[numSemester]++;
        counter++;
        if (grade == 3) isThree = true;
        if (grade == 5) counterFive++;
        else isFiveInSem[numSemester] = false;
        if (lastSem < numSemester) lastSem = numSemester;
    }

    /**
     * calculates the arithmetic mean of all grades
     * @return
     */
    public double averageGrade() {
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
    public boolean isIncreaseGrant() {
        if(lastSem != 1){
            if(isFiveInSem[lastSem] == true && isFiveInSem[lastSem - 1] == true) return true;
            return false;
        }
        else System.out.println("You haven't studied enough to raise your scholarship");
        return false;
    }

    /**
     * calculates whether it is possible to get a red diploma
     * @return
     */
    public boolean isRedDiploma(){
        int eightSem = 8;
        int threshold = 75;
        if (lastSem != eightSem) System.out.println("You are still far from red diploma)");
        if(((float)counterFive/counter * 100 >=threshold) && arrGrades.get(semester[8] - 1) == 5 && isThree == false) return true;
        return false;
    }
}
