package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.observer;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.ChangeType;

public interface TaskSubject {
    void attach(TaskSubscriber subscriber);
    void detach(TaskSubscriber subscriber);
    void notifySubscribers(ChangeType changeType, String oldValue, String newValue);
}
