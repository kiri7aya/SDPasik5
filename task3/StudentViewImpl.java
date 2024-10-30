import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentViewImpl extends JFrame implements StudentView {
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> studentList = new JList<>(listModel);
    private final JTextField nameInput = new JTextField(10);
    private final JTextField ageInput = new JTextField(10);
    private final JTextField courseInput = new JTextField(10);
    private final JButton addButton = new JButton("Add Student");

    public StudentViewImpl() {
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
