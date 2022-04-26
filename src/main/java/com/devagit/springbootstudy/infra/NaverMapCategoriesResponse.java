package com.devagit.springbootstudy.infra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@NoArgsConstructor
@Getter
@Setter
public class NaverMapCategoriesResponse {
    private int id;
    private String name;
    private int parentNum;

    public NaverMapCategoriesResponse(int id, String name,@Nullable int parentNum) {
        this.id = id;
        this.name = name;
        this.parentNum = parentNum;
    }
}
