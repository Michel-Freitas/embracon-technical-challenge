package com.challenge.michelfreitas.challenge.module.zipCode.service.Impl;

import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeLogResponse;
import com.challenge.michelfreitas.challenge.module.zipCode.dto.response.ZipCodeResponse;
import com.challenge.michelfreitas.challenge.module.zipCode.model.ZipCodeLog;
import com.challenge.michelfreitas.challenge.module.zipCode.repository.ZipCodeLogRepository;
import com.challenge.michelfreitas.challenge.module.zipCode.service.IZipCodeService;
import com.challenge.michelfreitas.challenge.module.zipCode.service.IZipCodeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZipCodeService implements IZipCodeService {

    @Autowired
    private IZipCodeWebService zipCodeWebService;

    @Autowired
    private ZipCodeLogRepository zipCodeLogRepository;

    @Override
    public ZipCodeResponse getByZipCode(String zipCode) {
        var zipCodeWsResponse = this.zipCodeWebService.getZipCodeByCode(zipCode);

        ZipCodeLog zipCodeLog = new ZipCodeLog(zipCodeWsResponse.cep(), zipCodeWsResponse.uf());
        this.zipCodeLogRepository.save(zipCodeLog);

        return new ZipCodeResponse(
                zipCodeWsResponse.cep(),
                zipCodeWsResponse.logradouro(),
                zipCodeWsResponse.bairro(),
                zipCodeWsResponse.localidade(),
                zipCodeWsResponse.uf()
            );
    }

    @Override
    public List<ZipCodeLogResponse> getZipCodeLogByUf(String uf) {
        PageRequest pageRequest = PageRequest.of(0, 20);
        var zipCodeLogList = this.zipCodeLogRepository.findAllByUf(uf, pageRequest);

        return zipCodeLogList.stream()
                .map(item -> new ZipCodeLogResponse(item.getZipCode(), item.getDateTimeConsultation()))
                .collect(Collectors.toList());
    }
}
