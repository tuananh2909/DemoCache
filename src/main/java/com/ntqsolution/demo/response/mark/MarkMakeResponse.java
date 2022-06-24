package com.ntqsolution.demo.response.mark;

import com.ntqsolution.demo.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkMakeResponse extends Response {

    int totalPoints;
    int studentId;

}
