package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;
import camp.utils.TypeConsts;
import java.util.ArrayList;
import java.util.List;
// ST SU SC

public class InitializeData {
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    // index 관리 필드
    private static int studentIndex;
    private static int subjectIndex;
    private static int scoreIndex;

    public InitializeData() {
        setInitData();
    }

    public static void setInitData() {
        subjectStore = List.of(
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "Java",
                        TypeConsts.SUBJECT_TYPE_MANDATORY.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "객체지향",
                        TypeConsts.SUBJECT_TYPE_MANDATORY.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "Spring",
                        TypeConsts.SUBJECT_TYPE_MANDATORY.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "JPA",
                        TypeConsts.SUBJECT_TYPE_MANDATORY.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "MySQL",
                        TypeConsts.SUBJECT_TYPE_MANDATORY.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        TypeConsts.SUBJECT_TYPE_CHOICE.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        TypeConsts.SUBJECT_TYPE_CHOICE.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "Redis",
                        TypeConsts.SUBJECT_TYPE_CHOICE.getType()
                ),
                new Subject(
                        sequence(TypeConsts.INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        TypeConsts.SUBJECT_TYPE_CHOICE.getType()
                )
        );
        studentStore = new ArrayList<>();
        scoreStore = new ArrayList<>();
    }
    public static String sequence(TypeConsts type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return TypeConsts.INDEX_TYPE_STUDENT.getType() + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return TypeConsts.INDEX_TYPE_SUBJECT.getType() + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return TypeConsts.INDEX_TYPE_SCORE.getType() + scoreIndex;
            }
        }
    }

    public static List<Student> getStudentStore() {
        return studentStore;
    }

    public static List<Subject> getSubjectStore() {
        return subjectStore;
    }

    public static List<Score> getScoreStore() {
        return scoreStore;
    }
}
