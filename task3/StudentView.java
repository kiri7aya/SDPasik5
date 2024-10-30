public interface StudentView {
    void displayStudents(List<Student> students);
    String getStudentName();
    int getStudentAge();
    String getStudentCourse();
    void setAddStudentListener(AddStudentListener listener);
}

public class StudentViewImpl extends JFrame implements StudentView {
    private DefaultListModel<String> listModel;
    private JList<String> studentList;
    private JTextField nameInput;
    private JTextField ageInput;
    private JTextField courseInput;
    private JButton addButton;

    public StudentViewImpl() {
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        nameInput = new JTextField(10);
        ageInput = new JTextField(10);
        courseInput = new JTextField(10);
        addButton = new JButton("Add Student");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameInput);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageInput);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseInput);
        inputPanel.add(addButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(studentList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void displayStudents(List<Student> students) {
        listModel.clear();
        students.forEach(student -> listModel.addElement(student.getName() + " - " + student.getCourse()));
    }

    @Override
    public String getStudentName() {
        return nameInput.getText();
    }

    @Override
    public int getStudentAge() {
        return Integer.parseInt(ageInput.getText());
    }

    @Override
    public String getStudentCourse() {
        return courseInput.getText();
    }

    @Override
    public void setAddStudentListener(AddStudentListener listener) {
        addButton.addActionListener(e -> listener.onAddStudent());
    }
}

// Main
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
