package com.example.employee_api.address;

public record AddressDTO(
        String address,
        Integer number,
        String neighborhood,
        String city,
        String state,
        String postalCode,
        String address2
) {

    public AddressDTO(Address address) {
        this(
                address.getAddress(),
                address.getNumber(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getPostalCode(),
                address.getAddress2()
        );
    }
}
