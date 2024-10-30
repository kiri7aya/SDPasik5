public class Main {
    public static void main(String[] args) {
        TodoView view = new TodoViewImpl();
        new TodoController(view);
    }
}
