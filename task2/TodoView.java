import java.util.List;

public interface TodoView {
    void displayTodos(List<Todo> todos);
    void setController(TodoController controller);
    String getNewTodoTitle();
}
