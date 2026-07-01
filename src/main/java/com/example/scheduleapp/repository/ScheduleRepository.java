package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//인터페이스 -> 주문서(규칙)
//
public interface ScheduleRepository extends JpaRepository<Schedule ,Long> {
    List<Schedule> findAllByAuthorOrderByModifiedAtDesc(String author);
    List<Schedule> findAllByOrderByModifiedAtDesc();
}
//제네릭 사용 <> 엔티티는 schedule , 타입 (기본키 ,@Id)