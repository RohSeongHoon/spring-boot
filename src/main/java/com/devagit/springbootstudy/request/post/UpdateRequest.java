package com.devagit.springbootstudy.request.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//이 클래스는 deleteRequest클래스와 요청이 같은데 하나로 묶어도 되는지 질문
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateRequest {
    private int id;

}
//수정된 시간