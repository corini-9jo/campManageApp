package camp.model;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectId;
    private int round;
    private int score2;
    private HashMap<Integer, Integer> score;    // round, score
    private String grade;

    public Score(String seq) {
        this.scoreId = seq;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public String getStudentId() { return studentId; }

    public String getSubjectId() { return subjectId; }

    public Map<Integer, Integer> getScore() { return score; }

    public String getGrade() { return grade; }

    // Setter
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public void setSubjectId(String subjectId) { this.subjectId = subjectId; }

    public void setScore(int key, int value) { this.score.put(key, value); }

    public void setGrade(String grade) { this.grade = grade; }
}
