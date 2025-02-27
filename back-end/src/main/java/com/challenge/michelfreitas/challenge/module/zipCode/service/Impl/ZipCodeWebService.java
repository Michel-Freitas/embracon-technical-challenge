package com.challenge.michelfreitas.challenge.module.zipCode.service.Impl;

import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeWsResponse;
import com.challenge.michelfreitas.challenge.module.zipCode.service.IZipCodeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ZipCodeWebService implements IZipCodeWebService {

    @Autowired
    private WebClient webClient;

    @Override
    public ZipCodeWsResponse getZipCodeByCode(String code) {
        return webClient.get()
                .uri("{code}/json", code)
                .retrieve()
                .bodyToMono(ZipCodeWsResponse.class)
                .block();
    }
}