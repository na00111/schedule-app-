package com.example.scheduleapp.entity; //경로

import com.example.scheduleapp.dto.ScheduleRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //테이블과 1:1로 매핑되는 객체임을 스프링과 jpa에게 선언
//실제 DB에 영구적으로 저장될 데이터의 구조를 정의하는
@Getter
@Table(name ="schedule")
@NoArgsConstructor (access = AccessLevel.PROTECTED)//기본 생성자(매개변수 없는)를 숨겨진 코드에 주입
public class Schedule extends BaseEntity{
    @Id //데이터베이스 테이블의 식별자 -> 기본 키가 될 필드임을 지정
    //기본키 -> 중복될 수 없는 유일한 키 VS 외래키 -> 다른 테이블의 기본키를 가리키는 연결고리
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id번호를 자동으로 생성
    private Long id;

    private String title;
    private String contents;
    private String author;
    private String password;
//    private String creat -> 생성일, 수정일 이미 자동으로 생성되서 안 만들어도됨.

    //생성자
//    //포스트맨이 보낸 데이터를 안전하게 받아서 엔티티 객체 안으로 값을 복사해 넣는 역할
//    public Schedule(String title, String contents, String author, String password) {
//        this.title = title;
//        this.contents = contents;
//        this.author = author;
//        this.password = password;
//    }
public Schedule(ScheduleRequest request) {
    this.title = request.getTitle();
    this.contents = request.getContents();
    this.author = request.getAuthor();
    this.password = request.getPassword();

}
public void update(String title, String author) {
    this.title = title;
    this.author = author;
}

}
