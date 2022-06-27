package com.ntqsolution.demo.request.teacher;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDeleteRequest extends BaseRequest<String> {
    public TeacherDeleteRequest(String data) {
        super(data);
    }
}
