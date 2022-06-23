package com.ntqsolution.demo.api;

import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;

public abstract class BaseAPI {
    public BaseResponse doExecute(BaseRequest request) {
        //validateRequest(request);
        return execute(request);
    }

    protected abstract void validateRequest(BaseRequest request);

    protected abstract BaseResponse execute(BaseRequest request);
}
