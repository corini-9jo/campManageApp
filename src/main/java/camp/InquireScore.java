package camp;

import camp.model.Score;

import java.util.List;
import java.util.Scanner;

public class InquireScore {
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
        String subjectId = sc.next();  // 수정할 과목 ID

        // 존재하지 않는 과목 입력시..
        if(subjectId.isBlank()){
            System.out.println("존재하지 않는 과목입니다(종료합니다..)");
            return;
        }

        // 수정할 회차 입력
        System.out.println("수정할 회차 입력 : ");
        int fix_round = sc.nextInt();
        sc.nextLine();

        // 존재 확인 후 점수 수정
        for(Score s : ScoreStore) {
            if(s.getStudentId().equals(studentId) && s.getSubjectId().equals(subjectId)){
                // 수정할 점수가 존재할 경우
                if (s.getScore().containsKey(fix_round)) {
                    // 수정할 점수 입력
                    System.out.println("수정할 점수 입력 : ");
                    int fix_score = sc.nextInt();
                    sc.nextLine();

                    // 점수 수정
                    if (0 <= fix_score && fix_score <= 100) {
                        System.out.println("시험 점수를 수정합니다...");
                        s.setScore(fix_round, fix_score);
                    } else {
                        // 입력할 수 없는 점수 입력시
                        System.out.println("입력할 수 없는 점수입니다(종료합니다..)");
                        break;
                    }
                } else {
                    // 존재하지 않는 회차 입력시
                    System.out.println("존재하지 않는 회차입니다(종료합니다..)");
                    break;
                }
            }
        }
    }
}
