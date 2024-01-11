package camp;

public class CampManagementApplication {

    public static void main(String[] args) {
        InquireStudent inqureStudent = new InquireStudent();
        inqureStudent.setInitData();
        inqureStudent.createStudent();
        inqureStudent.inquireStudentAll();

        InquireScore inquireScore = new InquireScore();
        inquireScore.updateRoundScoreBySubject();
    }
}