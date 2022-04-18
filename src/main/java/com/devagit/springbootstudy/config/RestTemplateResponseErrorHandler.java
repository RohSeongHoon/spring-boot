package com.devagit.springbootstudy.config;

import com.devagit.springbootstudy.exceptionHandler.notfound.NaverMapNotFoundException;
import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.ClientException;
import com.devagit.springbootstudy.exceptionHandler.restTemplateExceptionHandler.ServerException;
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
            throw new ClientException(response.getStatusCode());
        }
        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            throw new ServerException(response.getStatusCode());
        }
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new NaverMapNotFoundException();
        }
    }
}
