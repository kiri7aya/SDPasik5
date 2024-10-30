import java.util.List;

public interface StudentView {
    void displayStudents(List<Student> students);
    String getStudentName();
    int getStudentAge();
    String getStudentCourse();
    void setAddStudentListener(AddStudentListener listener);

    interface AddStudentListener {
        void onAddStudent();
    }
}
