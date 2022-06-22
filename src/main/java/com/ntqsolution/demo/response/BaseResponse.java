package com.ntqsolution.demo.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseResponse {
    private HttpStatus status;
}
