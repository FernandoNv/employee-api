package com.example.employee_api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {
    private String address;
    private Integer number;
    private String neighborhood;
    private String city;
    private String state;
    private String postalCode;
    private String address2;

    public Address(AddressSaveDTO addressSaveDTO) {
        this.address = addressSaveDTO.address();
        this.number = addressSaveDTO.number();
        this.neighborhood = addressSaveDTO.neighborhood();
        this.city = addressSaveDTO.city();
        this.state = addressSaveDTO.state();
        this.postalCode = addressSaveDTO.postalCode();
        this.address2 = addressSaveDTO.address2();
    }
}
