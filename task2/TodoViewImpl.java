import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TodoViewImpl extends JFrame implements TodoView {
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> todoList = new JList<>(listModel);
    private final JTextField todoInput = new JTextField(20);
    private final JButton addButton = new JButton("Add Todo");
    private TodoController controller;

    public TodoViewImpl() {
        setLayout(new BorderLayout());
        add(new JScrollPane(todoList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(todoInput);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            if (controller != null) controller.addTodo();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void displayTodos(List<Todo> todos) {
        listModel.clear();
        todos.forEach(todo -> listModel.addElement(todo.getTitle()));
    }

    @Override
    public void setController(TodoController controller) {
        this.controller = controller;
    }

    @Override
    public String getNewTodoTitle() {
        return todoInput.getText();
    }
}
