package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleRequest;
import com.example.scheduleapp.dto.ScheduleResponse;
import com.example.scheduleapp.dto.ScheduleUpdateRequest;
import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<ScheduleResponse> getSchedules(String author) {
        List<Schedule> schedules; //아직 초기화 안함.
//  getSchedules라고 이름 짓는 이유-> 전체 일정을 가져오니까 복수형
        //전체 조회 -> 리스트로 만들기
        if (author != null) {
            schedules = scheduleRepository.findAllByAuthorOrderByModifiedAtDesc(author);
        } else {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        }
        List<ScheduleResponse> responses = new ArrayList<>();
        for (Schedule schedule : schedules) {
            responses.add(new ScheduleResponse(schedule));
        }
        return responses;
    }

    public ScheduleResponse getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. 아이디는 " + id));
        //캡슐 여는 문법 ->.orElseThrow()
        return  new ScheduleResponse(schedule);
    }

    @Transactional //더티 체킹 -> 변경감지 자동으로 수해당
    public  ScheduleResponse updateSchedule(Long id, ScheduleUpdateRequest request) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. 아이디=" + id));
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
            schedule.update(request.getTitle), request.getAuthor());
return new ScheduleResponse(schedule);
        }
    }
        public void deleteSchedule(Long id , String password) {
            Schedule schedule = scheduleRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. 아이디="+ id));

            if (!schedule.getPassword().equals(password)) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
            }
            scheduleRepository.delete(schedule);
        }

}
