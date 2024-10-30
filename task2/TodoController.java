public class TodoController {
    private TodoView view;
    private List<Todo> todos;

    public TodoController(TodoView view) {
        this.view = view;
        this.todos = new ArrayList<>();
        this.view.setAddTodoListener(this::addTodo);
    }

    private void addTodo() {
        String title = view.getNewTodoTitle();
        if (!title.isEmpty()) {
            Todo newTodo = new Todo(todos.size(), title, false);
            todos.add(newTodo);
            view.displayTodos(todos);
        }
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        TodoView view = new TodoViewImpl();
        new TodoController(view);
    }
}
