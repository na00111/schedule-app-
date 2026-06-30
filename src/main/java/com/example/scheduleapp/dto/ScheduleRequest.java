package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
//받은 데이터를 서비스가 꺼내 써야 해서
//받은 데이터를 나중에 서비스나 엔티티에서 꺼내서 써야 하니까
public class ScheduleRequest {
    //id는 없음-> id는 DB가 순서대로 자동으로 발행하주는 것

    private String title;
    private String contents;
    private String author;
    private String password;
}

