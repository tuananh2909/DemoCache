package com.ntqsolution.demo.request.mark;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointMakeRequest extends BaseRequest {
    private int studentId;

    public PointMakeRequest(Object data, int studentId) {
        super(data);
        this.studentId = studentId;
    }
}
