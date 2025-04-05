
void main() {
    var todoList = new java.util.ArrayList<String>();

    todoList.add("Finish Java 23 tutorial");
    todoList.add("Review pull requests");
    todoList.add("Go for a walk");

    System.out.println("Your To-Do List:");
    todoList.forEach(task -> System.out.println("- " + task));
}
