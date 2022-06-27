package com.ntqsolution.demo.response.teacher;

import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherGetAllResponse extends Response {
    List<AbstractEntity> teacherList;
}
