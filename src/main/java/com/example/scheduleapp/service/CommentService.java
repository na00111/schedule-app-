package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.CommentRequest;
import com.example.scheduleapp.dto.CommmentResponse;
import com.example.scheduleapp.entity.Schedule;
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
    public CommmentResponse createComment(Long scheduleId, CommentRequest request) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new IllegalArgumentException("해당 일정이 존재하지 않습니다"));

        long commentCount = commentRepository.countByScheduleId(Long scheduleId);
    }
}
