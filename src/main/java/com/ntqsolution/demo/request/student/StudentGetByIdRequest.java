package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGetByIdRequest extends BaseRequest<String> {
    public StudentGetByIdRequest(String data) {
        super(data);
    }
}
