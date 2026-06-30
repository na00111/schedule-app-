package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleRequest;
import com.example.scheduleapp.dto.ScheduleResponse;
import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// private final 붙은 것을 자동으로 연결해준다 /롬복
public class ScheduleService {
    private  final ScheduleRepository scheduleRepository;
    public ScheduleResponse createSchedule(ScheduleRequest request) {
        Schedule schedule = new Schedule(request);
        //컨트롤러가 준 정보를 엔티티에서 만든 생성자를 사용해 내용을 엔티티에 저장하려고
        //public Schedule(ScheduleRequest request) {
        //    this.title = request.getTitle();
        //    this.contents = request.getContents();
        //    this.author = request.getAuthor();
        //    this.password = request.getPassword();
        Schedule savedSchedule = scheduleRepository.save(schedule);
        //리포지토리에 저장
        return  new ScheduleResponse(savedSchedule)
    }
}
