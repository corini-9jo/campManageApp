package camp.model;

public class Student {
    private String studentId;
    private String studentName;
    private Subject subject;
    private Score score;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

}
