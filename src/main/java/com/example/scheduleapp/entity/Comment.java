package com.example.scheduleapp.entity;

import com.example.scheduleapp.dto.CommentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter //외부에서 꺼내볼 수 있게
@NoArgsConstructor //기본생성자를 만들어줌.


public class Comment extends BaseEntity{
    @Id //기본키  DB 테이블의 모든 데이털ㄹ 구별할 수 있게
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//캡슐화 -> 다른 클래스들이 수정 못하게 / 게터나 생성자를 통해서만 데이터를 만지게 통제
    private Long id; //고유 번호표
    private String contents;
    private String author;
    private String password;

private  Long scheduleId; // 방 번호 숫자를 저장할 공간 Long으로 만들어주기

    //생성자
    public Comment(CommentRequest request ,Long scheduleId) {
        this.contents = request.getContents();
        this.author = request.getAuthor();
        this.password = request.getPassword();
        this.scheduleId = scheduleId; //클래스가 아니라서  변수 그  자체로 들어와 받음
    }

}
