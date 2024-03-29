package camp;

import static camp.InitializeData.sequence;

import camp.model.Student;
import camp.model.Subject;
import camp.utils.TypeConsts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManagement {
    private InitializeData initializeData;
    private List<Student> studentStore = initializeData.getStudentStore();
    private List<Subject> subjectStore = initializeData.getSubjectStore();

    Scanner sc = new Scanner(System.in);

    public StudentManagement(InitializeData initializeData) {
        this.initializeData = initializeData;
    }

    public void createStudent() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("\n수강생을 등록합니다...");
                System.out.print("수강생 이름 입력: ");
                String studentName = sc.nextLine();

                List<String> mandatoryList = selectMandatorySubject();
                List<String> choiceList = selectChoiceSubject();

                Map<String, List<String>> subjectList = new HashMap<>();
                subjectList.put(TypeConsts.SUBJECT_TYPE_MANDATORY.getType(), mandatoryList);
                subjectList.put(TypeConsts.SUBJECT_TYPE_CHOICE.getType(), choiceList);

                Student student = new Student(sequence(TypeConsts.INDEX_TYPE_STUDENT), studentName, subjectList);
                studentStore.add(student);

                System.out.println("\n수강생 등록 성공!\n");
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요...");
            }
        }
    }

    public void inquireStudentAll() {
        for (Student student : studentStore) {
            System.out.println("\n수강생 ID : " + student.getStudentId());
            System.out.println("수강생 이름 : " + student.getStudentName());
        }
    }

    private List<String> selectMandatorySubject() {
        System.out.println("아래의 필수과목 중 3개 이상을 선택해주세요.(쉼표롤 구분)");

        String mandatory = subjectStore.stream()
                .filter(subject -> subject.getSubjectType().equals(TypeConsts.SUBJECT_TYPE_MANDATORY.getType()))
                .map(Subject::getSubjectName)
                .collect(Collectors.joining(", "));
        System.out.println("[ " + mandatory + " ]");
        System.out.print("\n필수과목 선택: ");
        String mandatoryInput = sc.nextLine();
        List<String> mandatoryList = List.of(mandatoryInput.split(",\\s*"));
        validateSubjectListLength(mandatoryList, 3);
        validateSubjectList(mandatoryList);
        return  mandatoryList;
    }

    private List<String> selectChoiceSubject() {
        System.out.println("\n아래의 선택과목 중 2개 이상을 선택해주세요.(쉼표롤 구분)");
        String choice = subjectStore.stream()
                .filter(subject -> subject.getSubjectType().equals(TypeConsts.SUBJECT_TYPE_CHOICE.getType()))
                .map(Subject::getSubjectName)
                .collect(Collectors.joining(", "));

        System.out.println("[ " + choice + "]");
        System.out.print("\n선택과목 선택: ");
        String choiceInput = sc.nextLine();
        List<String> choiceList = List.of(choiceInput.split(",\\s*"));

        validateSubjectListLength(choiceList, 2);
        validateSubjectList(choiceList);

        return choiceList;
    }

    private void validateSubjectListLength(List<String> subjectList, int minLength) {
        if (subjectList.size() < minLength) {
            throw new IllegalArgumentException(
                String.format("해당 과목은 최소 %d개 이상 선택해야 합니다.", minLength)
            );
        }
    }

    private void validateSubjectList(List<String> subjectList) {
        List<String> allSubjects = subjectStore.stream()
                .map(Subject::getSubjectName)
                .collect(Collectors.toList());

        for (String subject : subjectList) {
            if (!allSubjects.contains(subject)) {
                throw new IllegalArgumentException("과목에 없는 과목이 선택되었습니다");
            }
        }
    }
}