package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.state;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Task;
import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.TaskStatus;

public class CancelledState implements TaskState {

    @Override
    public boolean canTransitionTo(TaskStatus newStatus) {
        // Can go to TODO (reactivate)
        return newStatus == TaskStatus.TODO;
    }

    @Override
    public void performTransition(Task task, TaskStatus newStatus) {
        if (canTransitionTo(newStatus)) {
            task.setStatus(newStatus);
        } else {
            throw new InvalidStateTransitionException(
                    "Cannot transition from CANCELLED to " + newStatus);
        }
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}