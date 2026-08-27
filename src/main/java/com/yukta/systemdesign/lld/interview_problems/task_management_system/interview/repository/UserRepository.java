package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.repository;


import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.User;

public interface UserRepository {
    User findById(int userId);
}


