package com.example.scheduleapp.dto;

import com.example.scheduleapp.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private Long id;
    private String contents;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long scheduleId; //이 댓글이 어떤 일정에 달렸는지 알려주는 일정 번호표

    //생성자 만들기
    //서비스가 DB에 댓글을 저장하고 나온 결과물 -> comment
    public CommentResponse(Comment comment) {
        //엔티티에서 캠슐화 되어있는 데이터 복사해 오기
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.author = comment.getAuthor();
        // BaseEntity
        this.createdAt = comment.getCreateAt();
        this.modifiedAt = comment.getModifiedAt();
        //비밀번호는 안적어준다
    }
}
