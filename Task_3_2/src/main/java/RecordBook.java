import java.util.ArrayList;

public class RecordBook {
    public static class Rec {
        private final String subject;
        private int grade;

        /**
         * @param name examination subject
         * @param grade grade for the subject on the exam.
         */
        public Rec(String name, int grade){
            if (grade > 5 || grade < 2) throw new IllegalArgumentException("grade must be between 2 and 5");
            subject = name;
            this.grade = grade;
        }

        /**
         * return grade
         */
        public int getGrade(){
            return grade;
        }
    }

    private final int semester;
    private int qualifyingWork = 0;
    private final ArrayList<ArrayList<Rec>> book;
    private String name;
    private String surname;

    /**
     * creating an empty record book
     * @param NumberOfSemester current semester number
     */
    public RecordBook(int NumberOfSemester, String name, String surname){
        if (NumberOfSemester < 1) throw new IllegalArgumentException("Semester number must be greater than 0");
        semester = NumberOfSemester;
        book = new ArrayList<ArrayList<Rec>>(NumberOfSemester);
        for (int i = 0; i<NumberOfSemester-1; i++){
            book.add(new ArrayList<Rec>());
        }
    }

    /**
     * @param grade grade for the diploma
     */
    public void qualifyingWork (int grade){
        if(grade > 5 || grade < 2) throw new IllegalArgumentException("grade must be between 2 and 5");
        qualifyingWork = grade;
    }


    /**
     * replace the semester with the transferred one
     * @param semester semester number to be replaced
     * @param page semester
     */
    public void replaceSemester(int semester, ArrayList<Rec> page){
        if (semester<1) throw new IllegalArgumentException("Semester number must be greater than 0");
        book.set(semester-1,page);
    }

    /**
     * Add an entry to an existing semester
     * @param semester semester number
     * @param record record
     */
    public void addRecordToSemester(int semester, Rec record) {
        if (semester<1) throw new IllegalArgumentException("Semester number must be greater than 0");
        if (record == null) throw new IllegalArgumentException("record argument must be! = null");
        book.get(semester-1).add(record);
    }

    /**
     * calculates whether it is possible to increase the scholarship
     * @return
     */
    public double averageGrade() {
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i<semester-1; i++){
            if (book.get(i)==null) throw new IllegalStateException("There are not enough semesters in the grade book");
            cnt += book.get(i).size();
            sum += book.get(i).stream().mapToInt(x -> x.getGrade()).sum();
        }
        return 1.0 * sum/cnt;
    }

    /**
     * calculates whether it is possible to increase the scholarship
     * @return
     */
    public boolean isIncreaseGrant() {
        ArrayList<Rec> sem = book.get(semester-2);
        if ((semester==1) || sem == null) throw new IllegalStateException("No previous semester in the grade book");
        if (sem.size()==0) throw new IllegalStateException("There are no entries from the previous semester in the gradebook");
        boolean flag = true;
        for (Rec r : sem){
            if (r.getGrade() != 5) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * calculates whether it is possible to get a red diploma
     * @return
     */
    public boolean isRedDiploma() {
        if ((qualifyingWork!= 0) && (qualifyingWork!= 5)) return false;
        ArrayList<Rec> lastGrades = new ArrayList<Rec>();
        for(ArrayList<Rec> sem : book){
            if (sem==null) throw new IllegalStateException("There are not enough semesters in the grade book");
            for(Rec r : sem){
                if (r.getGrade() <= 3) return false;
                boolean fl = true;
                for(Rec last : lastGrades){
                    if (last.subject.equals(r.subject)){
                        last.grade = r.getGrade();
                        fl = false;
                        break;
                    }
                }
                if (fl) lastGrades.add(new Rec(r.subject, r.getGrade()));
            }
        }
        double cnt = 0, sum = 0;
        for(Rec r : lastGrades){
            cnt++;
            sum += r.getGrade();
        }
        return ((1.0 * sum/cnt) >= 4.75);
    }
}
