package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.repository;
import com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);
    List<Comment> findByTaskId(int taskId);
}
