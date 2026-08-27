package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.repository;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Task;
import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.TaskSearchCriteria;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    Task findById(int taskId);
    List<Task> findByAssignee(int assigneeId);
    List<Task> findByParentTask(int parentTaskId);
    List<Task> search(TaskSearchCriteria criteria);
    void delete(int taskId);
}

