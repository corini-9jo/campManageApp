package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InquireStudent {
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;

    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";
    public void setInitData() {

        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
        ScoreStore = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    // 수강생 등록
    public void createStudent() {
        for (int i = 0; i < 4;i++) {
           studentStore.add(new Student(sequence(INDEX_TYPE_STUDENT), "test"));
        }
    }

    // 수강생 목록 조회
    public void inquireStudentAll() {
        for (Student student: studentStore) {
            System.out.println("수강생 ID : " + student.getStudentId());
            System.out.println("수강생 이름 : " + student.getStudentName());
        }
    }

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
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
