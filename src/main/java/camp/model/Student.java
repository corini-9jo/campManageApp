package camp.model;

import java.util.List;
import java.util.Map;

public class Student {
    private String studentId;
    private String studentName;
    private Map<String, List<String>> subject;
    private Score score;

    public Student(String seq, String studentName, Map<String, List<String>> subject) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subject = subject;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Score getScore() {
        return score;
    }
}
