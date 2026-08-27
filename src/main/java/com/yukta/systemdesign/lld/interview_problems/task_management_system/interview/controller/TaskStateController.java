package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.controller;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.TaskStatus;
import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.service.TaskStateService;

public class TaskStateController {
    private TaskStateService taskStateService;

    public TaskStateController(TaskStateService taskStateService) {
        this.taskStateService = taskStateService;
    }

    public void updateTaskStatus(int taskId, TaskStatus newStatus) {
        taskStateService.updateTaskStatus(taskId, newStatus);
    }
}
