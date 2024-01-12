package camp;

public class CampManagementApplication {

    public static void main(String[] args) throws InterruptedException {
//        StudentManagement inqureStudent = new StudentManagement();
//        inqureStudent.setInitData();
//        inqureStudent.createStudent();
//        inqureStudent.inquireStudentAll();
//
//        ModifyScore modifyScore = new ModifyScore();
//        modifyScore.updateRoundScoreBySubject();

        CreateScore createScore = new CreateScore();
        createScore.setInitData();
        createScore.displayMainView();
    }
}
