package com.example.scheduleapp.controller;

import com.example.scheduleapp.dto.ScheduleResponse;
import com.example.scheduleapp.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

//JOSN 데이터를  받아서 DTO로 변환
@RestController //이걸 써서 컨트롤러라고 알려주는 것
@RequestMapping("/schedules")
// /api -> 지금부터 요청하는 주소는 화면이 아니라 순수 데이터를 주고받는 창구api라고 알려줌

public class ScheduleController {
    private final ScheduleService scheduleService; //서비스 호출


    }
    // 일정을 생성하는 api
    //  ScheduleService 임포트 되는 이유 -> 같은 프로젝트(폴더)안에 있어도 패키지(폴더)가 다르면 남남임.

    @PostMapping
    public ScheduleResponse createSchedule(@RequestBody  ScheduleResponse response) {
       //타임 변수명 앞에 애노테이션이라는 옵션 스티커 붙인 것
        return scheduleService.createSchedule(request)
    }
}
