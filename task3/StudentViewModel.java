public class StudentViewModel {
    private List<Student> students;

    public StudentViewModel() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String course) {
        students.add(new Student(name, age, course));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void updateStudent(int index, String name, int age, String course) {
        Student student = students.get(index);
        student.setCourse(course);
    }
}
