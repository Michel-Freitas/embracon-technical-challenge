package com.challenge.michelfreitas.challenge.module.zipCode.dto.response;

import java.util.Date;

public record ZipCodeLogResponse(
        String zipCode,
        Date dateTimeConsultation
) { }
