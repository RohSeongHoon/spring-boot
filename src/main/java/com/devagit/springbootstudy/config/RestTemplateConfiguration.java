package com.devagit.springbootstudy.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplateBuilder restTemplateBuilder(){
        return new RestTemplateBuilder()
                .setReadTimeout(Duration.ofMillis(5000))
                .setConnectTimeout(Duration.ofMillis(5000));
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    //빌더패턴 팩토리패턴 공부
    //흐름 생각
    //설정은 설정파일에서 해야하는것을 알아야함
    //yml에서 하기도 하지만 명시적으로 코드를 작성
    //String 말고 오브젝트로
    //post도

}
