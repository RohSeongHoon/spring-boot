package com.devagit.springbootstudy.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
    private List<Documents> addresses;

    public AddressResponse(List<Documents> addresses) {
        this.addresses = addresses;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class Documents{
         private String addressName;
         private String roadAddressName;

        public Documents(String addressName, String roadAddressName) {
            this.addressName = addressName;
            this.roadAddressName = roadAddressName;
        }
    }
}
