package com.ntqsolution.demo.request.teacher;

import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherUpdateRequest extends BaseRequest<Teacher> {
    public TeacherUpdateRequest(Teacher data) {
        super(data);
    }
}
