package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class CreateScore {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static final Scanner sc = new Scanner(System.in);

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
        studentStore = List.of(
//                new Student(sequence(INDEX_TYPE_STUDENT),
//                        "김철수"),
//                new Student(sequence(INDEX_TYPE_STUDENT),
//                        "신짱구"),
//                new Student(sequence(INDEX_TYPE_STUDENT),
//                        "이훈이"),
//                new Student(sequence(INDEX_TYPE_STUDENT),
//                        "최유리"),
//                new Student(sequence(INDEX_TYPE_STUDENT),
//                        "박맹구")
        );
        ScoreStore = new ArrayList<>();
    }
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

    public void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private  void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    public static void createStudent(){

    }
    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        // 기능 구현
        System.out.println("\n수강생 목록 조회 성공!");
    }

    private  void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록

                case 3 -> inquireScore(); // 수강생 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static String getStudentId() {
        System.out.print("\n수강생의 번호를 입력하시오...");
        return sc.next();
    }

    private static String getSubjectId(){
        System.out.print("\n과목 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    public  void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        String subjectId = getSubjectId(); // 과목 고유 번호

        Optional<Student> findStudent = findStudentById(studentId);
        if(!findStudent.isPresent()){
            System.out.println("존재 하지 않은 학생입니다.");
            return;
        }

        Optional<Subject> findSubject = findSubjectById(subjectId);
        if(!findSubject.isPresent()){
            System.out.println("존재 하지 않은 과목입니다.");
            return;
        }

        System.out.println("시험 점수를 등록합니다...");

        System.out.print("회차 => ");
        int round = sc.nextInt();

        System.out.print("점수 => ");
        int score = sc.nextInt();

        String grade = createGrade(score,findSubject.get().getSubjectType());

        Optional<Score> findScore = findScoreByIdWithRound(studentId,subjectId,round);
        if(findScore.isPresent()){
            System.out.println("이미 존재하는 회차입니다.");
            return;
        }

        Score s = new Score.Builder()
                .setScoreId(sequence(INDEX_TYPE_SCORE))
                .setStudentId(studentId)
                .setSubjectId(subjectId)
                .setRound(round)
                .setScore(score)
                .setGrade(grade)
                .build();

        ScoreStore.add(s);

        System.out.println("\n점수 등록 성공!");
    }

    private static Optional<Student> findStudentById(String studentId){
        return studentStore.stream()
                .filter(s ->s.getStudentId().equals(studentId))
                .findFirst();
    }

    private static Optional<Subject> findSubjectById(String subjectId){
        return subjectStore.stream()
                .filter(s ->s.getSubjectId().equals(subjectId))
                .findFirst();
    }

    private static Optional<Score> findScoreByIdWithRound(String studentId, String subjectId, int round){
        return ScoreStore.stream()
                .filter(s ->(s.getStudentId().equals(studentId) &&
                        s.getSubjectId().equals(subjectId) && s.getRound() == round))
                .findFirst();
    }

    private static String createGrade(int score, String subjectType) {
        if (subjectType.equals("필수"))
            return createRequiredGrade(score);
        else
            return createElectiveGrade(score);
    }

    private static String createRequiredGrade(int score) {
        if (score >= 95) return "A";
        else if (score >= 90 && score <= 94) return "B";
        else if (score >= 80 && score <= 89) return "C";
        else if (score >= 70 && score <= 70) return "D";
        else if (score >= 60 && score <= 69) return "F";
        else return "N";
    }

    private static String createElectiveGrade(int score) {
        int n = score / 10;

        switch (n) {
            case 10, 9 -> {
                return "A";
            }
            case 8 -> {
                return "B";
            }
            case 7 -> {
                return "C";
            }
            case 6 -> {
                return "D";
            }
            case 5 -> {
                return "F";
            }
            default -> {
                return "N";
            }
        }
    }

    private void inquireScore(){
        String studentId = getStudentId(); // 조회할 수강생 고유 번호
        String subjectId = getSubjectId(); // 조회할 과목 고유 번호

        // 수강생 및 과목 고유 번호에 맞는 점수 탐색
        List<Score> scoreList = ScoreStore.stream()
                .filter(s -> s.getStudentId().equals(studentId) && s.getSubjectId().equals(subjectId))
                .toList();


        // 탐색 후 결과가 없을 시 리턴
        if(scoreList.isEmpty()) {
            System.out.println("해당 시험 결과가 없습니다");

            return;
        }

        // 점수 출력
        System.out.println("학생 ID : " + studentId);
        System.out.println("과목 ID : " + subjectId);
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + "회차\t| ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // round 순서대로 정렬
            Score roundScore = scoreList.stream()
                    .filter(score -> score.getRound() == (finalI + 1))
                    .findFirst()
                    .orElse(null);
            // 등급 출력, null 일시 - 출력
            if (roundScore != null) {
                System.out.print(roundScore.getGrade() + " 등급\t| ");
            } else {
                System.out.print("- 등급\t| ");
            }
        }
        System.out.println();
    }
}
