package com.example.scheduleapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
//클래스 내부의 변수(필드)를 외부에 보여줄때  값을 안전하게 꺼내올 수 있는 메서드를 만들어야 함.
//롬복이 메서드를 자동으로 만들어주는 애노테이션
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
//데이터가 DB에 새로 저장, 수정될 때 필드에 주입해줌
public abstract class BaseEntity {// 공통 필드를 모아서 부모 클래스를 생성
    //DB 테이블은 상속이라는 개념이 없음 ->
    //abstract(추상 클래스) 하는 이유 -> 이 크래스는 단독으로 객체를 만들 수 없고 , 다른 엔티티의 부모로서 상속으로만 사용 가능
    //자동으로 시간이 기록
    @CreatedDate //엔티티가 최초로 저장될 때 이게 붙은 필드에 현재 시간을 자동으로 ㅉ기어줌
    @Column(updatable = false) // 처음에 데이터가 들어올 때만 저장,이후 sql 업데이트문이ㅣ 날아갈 때는 절대로 수정X

    private LocalDateTime createAt;
    //LocalDateTime -> 연/월/일/시/분/초 를 모두 포함하는 타입

    @LastModifiedDate //데이터가 수정될 떼마다 이게 뭍은 필드의 시간을 새로운 현재 시간으로 업데이트 해줌.
    private LocalDateTime modifiedAt;
}
