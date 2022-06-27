package com.ntqsolution.demo.request.teacher;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherGetByIdRequest extends BaseRequest<String> {
    public TeacherGetByIdRequest(String data) {
        super(data);
    }
}
