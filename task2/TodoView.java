public interface TodoView {
    void displayTodos(List<Todo> todos);
    void setAddTodoListener(AddTodoListener listener);
    String getNewTodoTitle();
}

public class TodoViewImpl extends JFrame implements TodoView {
    private DefaultListModel<String> listModel;
    private JList<String> todoList;
    private JTextField todoInput;
    private JButton addButton;

    public TodoViewImpl() {
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        todoInput = new JTextField(20);
        addButton = new JButton("Add Todo");

        setLayout(new BorderLayout());
        add(new JScrollPane(todoList), BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputPanel.add(todoInput);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.SOUTH);

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
    public void setAddTodoListener(AddTodoListener listener) {
        addButton.addActionListener(e -> listener.onAddTodo());
    }

    @Override
    public String getNewTodoTitle() {
        return todoInput.getText();
    }
}
