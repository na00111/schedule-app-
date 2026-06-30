package com.example.scheduleapp.dto;

import com.example.scheduleapp.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

//DTO --> 클라이언트에게 보여주고 싶은 데이터만 골라 담는 바구기
@Getter
//DTO에 데이터를 담아서  정보를 보낼 때 스프링 안에서 jackson 라이브러리가 DTO(자바 객체)를
//네트워크로 전송할 수 있는 json텍스트 형태로 변환하려고 할때 DTO 안의 필드들이 프라이빗이니까
//게터를 사용해서 내용을 꺼내서 보내줌
public class ScheduleResponse {
    private Long id;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponse(Schedule schedule) {
        //게터 , 스캐쥴 받는 생성자
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.author = schedule.getAuthor();
        this.createAt = schedule.getCreateAt();
        this.modifiedAt =schedule.getModifiedAt();
    }
}
