package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDeleteRequest extends BaseRequest<Integer> {
    public StudentDeleteRequest(Integer data) {
        super(data);
    }
}
