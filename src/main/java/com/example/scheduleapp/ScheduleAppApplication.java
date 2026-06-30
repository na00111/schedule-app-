package com.example.scheduleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //데이터가 생성되거나 수정될 때 시간을 자동으로 기록해주는 기능 (@CresteDate, @LastModi
@SpringBootApplication //entry point임을 알리는 핵식 어노테이션
public class ScheduleAppApplication {
//프로그램이 메모리에 올라가서 최초로 구동되는
    public static void main(String[] args) {
        SpringApplication.run(ScheduleAppApplication.class, args);
    }
//톰캣 내장 서버와 함께 실행한다.
    //첫 번재 인자 (ScheduleApplication.class)는 시작점 클래스를 지정,
    //두 번째(args)는 외부에서 넘겨받은 옵션을 전달.곳
}
