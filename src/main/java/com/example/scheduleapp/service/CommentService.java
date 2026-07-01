package com.example.scheduleapp.service;

import com.example.scheduleapp.repository.CommentRepository;
import com.example.scheduleapp.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private  final CommentRepository commentRepository;
    private  final ScheduleRepository scheduleRepository;

    @Transactional
    public  CommmentResponse createComment(Long scheduleId,CommentRequest)
}
