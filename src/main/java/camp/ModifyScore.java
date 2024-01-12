package camp;

import camp.model.Score;

import java.util.List;
import java.util.Scanner;

public class ModifyScore {
    private static List<Score> ScoreStore;

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 회차 점수 수정
    public static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호

        // 수정할 과목 입력
        System.out.println("수정할 과목 입력 : ");
        String subjectId = sc.next();  // 수정할 과목

        // 수정할 회차 입력
        System.out.println("수정할 과목 입력 : ");
        int fix_round = sc.nextInt();  // 수정할 회차
        sc.nextLine();
        
        // 입력된 회차 범위 확인
        if(!(1 <= fix_round && fix_round <= 10)){
            System.out.println("잘못된 입력 범위입니다.");
            return;
        }
        
        // 수정할 과목 및 회차 정보가 존재하는지 확인 
        for(Score s : ScoreStore){
            // 수강생 고유 번호 & 과목 존재 여부 & 수정할 회차 확인
            if(s.getStudentId().equals(studentId) && s.getSubjectId().equals(subjectId) && s.getRound() == fix_round){
                // 수정할 점수 입력
                System.out.println("수정할 과목 입력 : ");
                int fix_score = sc.nextInt();  // 수정할 점수
                sc.nextLine();

                // 입력된 점수 범위 확인
                if(!(0 <= fix_score && fix_score <= 100)){
                    System.out.println("잘못된 입력 범위입니다.");
                    return;
                }

                // 정보 수정
                s.setScore(fix_score);

                // 종료
                System.out.println("시험 점수를 수정합니다...");
                return;
            }
        }
    }
}
