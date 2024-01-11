package camp;

public class CampManagementApplication {

    public static void main(String[] args) {
        StudentManagement inqureStudent = new StudentManagement();
        inqureStudent.setInitData();
        inqureStudent.createStudent();
        inqureStudent.inquireStudentAll();

        InquireScore inquireScore = new InquireScore();
        inquireScore.updateRoundScoreBySubject();
    }
}