package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.state;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Task;
import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.TaskStatus;
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.state.InvalidStateTransitionException;

public class ReviewState implements TaskState {

    @Override
    public boolean canTransitionTo(TaskStatus newStatus) {
        // Can go to COMPLETED, IN_PROGRESS
        return newStatus == TaskStatus.COMPLETED || newStatus == TaskStatus.IN_PROGRESS;
    }

    @Override
    public void performTransition(Task task, TaskStatus newStatus) {
        if (canTransitionTo(newStatus)) {
            task.setStatus(newStatus);
        } else {
            throw new InvalidStateTransitionException(
                    "Cannot transition from REVIEW to " + newStatus);
        }
    }

    @Override
    public String getStateName() {
        return "REVIEW";
    }
}
