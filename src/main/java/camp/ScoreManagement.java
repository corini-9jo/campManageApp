package camp;

import static camp.InitializeData.sequence;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import camp.utils.TypeConsts;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class ScoreManagement {
    private InitializeData initializeData;
    private List<Student> studentStore = initializeData.getStudentStore();
    private List<Subject> subjectStore = initializeData.getSubjectStore();
    private List<Score> scoreStore = initializeData.getScoreStore();
    // 수강생의 과목별 시험 회차 및 점수 등록
    private static final Scanner sc = new Scanner(System.in);

    public ScoreManagement(InitializeData initializeData) {
        this.initializeData = initializeData;
    }
    private static String getStudentId() {
        System.out.print("\n수강생의 번호를 입력하시오...");
        return sc.next();
    }

    private static String getSubjectId(){
        System.out.print("\n과목 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    public void createScore() {
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
                .setScoreId(sequence(TypeConsts.INDEX_TYPE_SCORE))
                .setStudentId(studentId)
                .setSubjectId(subjectId)
                .setRound(round)
                .setScore(score)
                .setGrade(grade)
                .build();

        scoreStore.add(s);

        System.out.println("\n점수 등록 성공!");
    }

    private Optional<Student> findStudentById(String studentId){
        return studentStore.stream()
                .filter(s ->s.getStudentId().equals(studentId))
                .findFirst();
    }

    private Optional<Subject> findSubjectById(String subjectId){
        return subjectStore.stream()
                .filter(s ->s.getSubjectId().equals(subjectId))
                .findFirst();
    }

    private Optional<Score> findScoreByIdWithRound(String studentId, String subjectId, int round){
        return scoreStore.stream()
                .filter(s ->(s.getStudentId().equals(studentId) &&
                        s.getSubjectId().equals(subjectId) && s.getRound() == round))
                .findFirst();
    }

    private String createGrade(int score, String subjectType) {
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

    public void inquireScore(){
        String studentId = getStudentId(); // 조회할 수강생 고유 번호
        String subjectId = getSubjectId(); // 조회할 과목 고유 번호

        // 수강생 및 과목 고유 번호에 맞는 점수 탐색
        List<Score> scoreList = scoreStore.stream()
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

    public void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 조회할 수강생 고유 번호
        String subjectId = getSubjectId(); // 조회할 과목 고유 번호

        // 수정할 회차 입력
        System.out.print("\n수정할 회차 => ");
        int fix_round = sc.nextInt();  // 수정할 회차
        sc.nextLine();

        // 입력된 회차 범위 확인
        if(!(1 <= fix_round && fix_round <= 10)){
            System.out.print("잘못된 입력 범위입니다.");
        }

        // 수정할 과목 및 회차 정보가 존재하는지 확인
        for(Score s : scoreStore){
            // 수강생 고유 번호 & 과목 존재 여부 & 수정할 회차 확인
            if(s.getStudentId().equals(studentId) && s.getSubjectId().equals(subjectId) && s.getRound() == fix_round){
                // 수정할 점수 입력
                System.out.print("수정할 점수 => ");
                int fix_score = sc.nextInt();  // 수정할 점수
                sc.nextLine();

                // 입력된 점수 범위 확인
                if(!(0 <= fix_score && fix_score <= 100)){
                    System.out.print("잘못된 입력 범위입니다.");
                }

                // 정보 수정
                s.setScore(fix_score);

                int n = fix_score / 10;
                switch (n) {
                    case 10, 9 -> {
                        s.setGrade("A");
                        break;
                    }
                    case 8 -> {
                        s.setGrade("B");
                        break;
                    }
                    case 7 -> {
                        s.setGrade("C");
                        break;
                    }
                    case 6 -> {
                        s.setGrade("D");
                        break;
                    }
                    case 5 -> {
                        s.setGrade("F");
                        break;
                    }
                    default -> {
                        s.setGrade("N");
                        break;
                    }
                }


                // 종료
                System.out.println("시험 점수가 수정되었습니다.");
            }
            else{
                System.out.println("입력한 정보에 맞는 데이터가 없습니다.");
            }
        }
    }
}
