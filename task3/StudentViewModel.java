import java.util.ArrayList;
import java.util.List;

public class StudentViewModel {
    private final List<Student> students;

    public StudentViewModel() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String course) {
        students.add(new Student(name, age, course));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void updateStudent(int index, String course) {
        if (index >= 0 && index < students.size()) {
            students.get(index).setCourse(course);
        }
    }
}
