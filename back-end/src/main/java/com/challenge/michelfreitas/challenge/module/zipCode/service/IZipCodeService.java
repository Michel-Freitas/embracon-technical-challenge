package com.challenge.michelfreitas.challenge.module.zipCode.service;

import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeLogResponse;
import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeResponse;

import java.util.List;

public interface IZipCodeService {

    ZipCodeResponse getByZipCode(String zipCode);
    List<ZipCodeLogResponse> getZipCodeLogByUf(String uf);
}
