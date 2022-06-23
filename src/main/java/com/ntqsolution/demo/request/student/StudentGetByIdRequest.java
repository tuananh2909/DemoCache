package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGetByIdRequest extends BaseRequest<Integer> {
    public StudentGetByIdRequest(Integer data) {
        super(data);
    }
}
