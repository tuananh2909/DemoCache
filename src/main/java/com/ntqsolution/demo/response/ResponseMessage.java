package com.ntqsolution.demo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseMessage extends BaseResponse {
    private String message;
    private Object data;

    public ResponseMessage(String message, HttpStatus status) {
        super(status);
        this.message = message;
    }

    public ResponseMessage(String message, Object data, HttpStatus status) {
        super(status);
        this.message = message;
        this.data = data;
    }
}
