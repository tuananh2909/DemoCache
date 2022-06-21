package com.ntqsolution.demo.response;

import lombok.*;

@Data
@AllArgsConstructor
public class ResponseMessage {
    private String message;
    private Object data;
}
