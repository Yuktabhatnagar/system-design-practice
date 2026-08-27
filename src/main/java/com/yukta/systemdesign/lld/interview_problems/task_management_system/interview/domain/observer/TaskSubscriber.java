package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.observer;

import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.ChangeType;

public interface TaskSubscriber {
    void update(int taskId, ChangeType changeType, String oldValue, String newValue);
}
