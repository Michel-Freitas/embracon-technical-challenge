package com.challenge.michelfreitas.challenge.module.zipCode.service;

import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeResponse;

public interface IZipCodeService {

    ZipCodeResponse getByZipCode(String zipCode);
}
