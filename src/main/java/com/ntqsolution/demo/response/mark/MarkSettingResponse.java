package com.ntqsolution.demo.response.mark;

import com.ntqsolution.demo.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class MarkSettingResponse extends Response {

    Map<String, Integer> points = new HashMap<>();

}
