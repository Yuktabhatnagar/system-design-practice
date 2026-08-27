package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.controller;

import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.service.TaskAssignmentService;

public class TaskAssignmentController {
    private TaskAssignmentService taskAssignmentService;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    public void assignTask(int taskId, int assigneeId) {
        taskAssignmentService.assignTask(taskId, assigneeId);
    }
}
