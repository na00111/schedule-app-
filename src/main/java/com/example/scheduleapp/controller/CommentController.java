package com.example.scheduleapp.controller;

import com.example.scheduleapp.dto.CommentRequest;
import com.example.scheduleapp.dto.CommentResponse;
import com.example.scheduleapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;
    //서비스를 필드로 만들어야 쓸 수 있음
    //의존성 주입 dependency injection
    //어떤 클래스의 메서드를 쓰고 싶다면 , 무조건 내 클래스 안에 그 변수(필드)로 등록해야 한다.
    @PostMapping("/{scheduleId}/comments")
    public CommentResponse createComment(
            @PathVariable Long scheduleId, //주소창에서 일정 번호표를 꺼내서 담음
            @RequestBody CommentRequest request //데이터를 꺼내서 담음
             ) {
        return commentService.createComment(scheduleId , request);
        //서비스한테 리턴해줌

    }
}
