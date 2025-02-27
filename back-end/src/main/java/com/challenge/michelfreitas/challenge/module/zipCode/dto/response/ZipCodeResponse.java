package com.challenge.michelfreitas.challenge.module.zipCode.dto.response;

public record ZipCodeResponse(
    String zipCode,
    String street,
    String neighborhood,
    String city,
    String uf
) { }