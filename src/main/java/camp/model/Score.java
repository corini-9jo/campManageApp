package camp.model;

import java.util.HashMap;

public class Score {
    private String scoreId;
    private String studentId;
    private String subjectId;

    private int round;

    private int score;
    private String grade;

    private Score() {
    }


    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public static class Builder{
        private Score score;

        public Builder(){
            this.score = new Score();
        }

        public Builder setScoreId(String scoreId){
            this.score.setScoreId(scoreId);
            return this;
        }

        public Builder setStudentId(String studentId){
            this.score.setStudentId(studentId);
            return this;
        }

        public Builder setSubjectId(String subjectId){
            this.score.setSubjectId(subjectId);
            return this;
        }

        public Builder setRound(int round){
            this.score.setRound(round);
            return this;
        }
        public Builder setScore(int score){
            this.score.setScore(score);
            return this;
        }

        public Builder setGrade(String grade){
            this.score.setGrade(grade);
            return this;
        }

        public Score build() {
            return this.score;
        }
    }
}
