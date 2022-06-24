package com.ntqsolution.demo.request.mark;

import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointMakeRequest extends BaseRequest {
    private String studentId;

    public PointMakeRequest(String studentId, Object data) {
        super(data);
        this.studentId = studentId;
    }
}
