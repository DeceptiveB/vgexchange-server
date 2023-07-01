package com.example.videogamexchange.models.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Address {

    @Size(max = 40)
    private String city;

    @NotBlank
    @Size(max = 40)
    private String street;

    @Size(max=10)
    private String zipcode;

    @NotBlank
    @Size(max=10)
    private String number;

    public Address() {
    }

    public Address(String city, String street, String zipcode, String number) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
    }
}
