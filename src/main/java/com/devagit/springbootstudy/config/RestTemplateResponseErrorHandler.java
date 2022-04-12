package com.devagit.springbootstudy.config;

import com.devagit.springbootstudy.exceptionHandler.notfound.NaverMapNotFoundException;
import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.ClientErrorHandler;
import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.ServerErrorHandler;
import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.TimeOutExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (
                response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ||
                        response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR
        );
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            throw new ClientErrorHandler(response.getStatusCode());
        }
        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            throw new ServerErrorHandler(response.getStatusCode());
        }
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new NaverMapNotFoundException();
        }
    }
}
