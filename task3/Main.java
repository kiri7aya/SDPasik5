public class Main {
    public static void main(String[] args) {
        StudentView view = new StudentViewImpl();
        StudentViewModel viewModel = new StudentViewModel();

        view.setAddStudentListener(() -> {
            String name = view.getStudentName();
            int age = view.getStudentAge();
            String course = view.getStudentCourse();
            viewModel.addStudent(name, age, course);
            view.displayStudents(viewModel.getStudents());
        });
    }
}
