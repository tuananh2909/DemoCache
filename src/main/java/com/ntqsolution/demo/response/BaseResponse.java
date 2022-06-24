package com.ntqsolution.demo.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private String message;
    private Response data;
    private HttpStatus status;

    public BaseResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
