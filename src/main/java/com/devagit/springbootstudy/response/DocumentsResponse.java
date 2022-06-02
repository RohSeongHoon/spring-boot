package com.devagit.springbootstudy.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DocumentsResponse {
    private String id;
    private String addressName;

    public DocumentsResponse(String id, String addressName) {
        this.id = id;
        this.addressName = addressName;
    }
}
