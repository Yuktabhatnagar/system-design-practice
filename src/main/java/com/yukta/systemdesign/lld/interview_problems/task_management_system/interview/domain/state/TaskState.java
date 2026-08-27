package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.state;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Task;
import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.TaskStatus;

public interface TaskState {
    boolean canTransitionTo(TaskStatus newStatus);
    void performTransition(Task task, TaskStatus newStatus);
    String getStateName();
}
