package com.yukta.systemdesign.lld.high_design_pattterns.mvc_pattern;

public class MvcPatternDemo {

    public static void main(String[] args) {
        Task model = new Task("Revise design patterns", false);
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        controller.render();
        controller.markComplete();
        controller.render();
    }
}

class Task {

    private final String title;
    private boolean completed;

    Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    String getTitle() {
        return title;
    }

    boolean isCompleted() {
        return completed;
    }

    void markComplete() {
        completed = true;
    }
}

class TaskView {

    void display(Task task) {
        System.out.println(task.getTitle() + " | completed=" + task.isCompleted());
    }
}

class TaskController {

    private final Task task;
    private final TaskView view;

    TaskController(Task task, TaskView view) {
        this.task = task;
        this.view = view;
    }

    void markComplete() {
        task.markComplete();
    }

    void render() {
        view.display(task);
    }
}
