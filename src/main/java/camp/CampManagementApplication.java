package camp;

import java.util.Scanner;

public class CampManagementApplication {
    public static void main(String[] args) throws InterruptedException {
        InitializeData initializeData = new InitializeData();
        StudentManagement studentManagement = new StudentManagement(initializeData);
        ScoreManagement scoreManagement = new ScoreManagement(initializeData);
        ApplicationView applicationView = new ApplicationView(studentManagement, scoreManagement);
        applicationView.displayMainView();
    }
}
