package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.strategy;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Task;

import java.util.List;

public interface TaskSortingStrategy {
    List<Task> sort(List<Task> tasks);
    String getStrategyName();
}
