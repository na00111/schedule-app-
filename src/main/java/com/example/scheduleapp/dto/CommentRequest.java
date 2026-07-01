package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter // 필드들이 프라이빗으로 잠겨있어서 ,서비스에서 쓸 수 있게 자동으로 게터 써주기

        //댓글을 달 때 컨트롤러에 제출할 것
public class CommentRequest {
    private String Contents;
    private String Author;
    private String password;

//   private String getPassword
//위에 게터를 써줘서 이렇게 안 적어도됨

}