package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.strategy;

import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Task;

import java.util.List;

public class TaskSortingContext {
    private TaskSortingStrategy strategy;

    public void setSortingStrategy(TaskSortingStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Task> sortTasks(List<Task> tasks) {
        if (strategy == null) {
            // Default to priority sorting
            strategy = new PrioritySortingStrategy();
        }
        return strategy.sort(tasks);
    }
}


