package com.devagit.springbootstudy.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class NaverMapCategories {
    private int id;
    private String name;
    @JsonProperty("name_kr")
    private String nameKr;

    public NaverMapCategories(int id, String name, String nameKr) { //
        this.id = id;
        this.name = name;
        this.nameKr = nameKr;
    }
}
