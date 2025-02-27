package com.challenge.michelfreitas.challenge.module.zipCode.service;

import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeWsResponse;

public interface IZipCodeWebService {
    ZipCodeWsResponse getZipCodeByCode(String code);
}