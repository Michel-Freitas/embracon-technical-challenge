package com.challenge.michelfreitas.challenge.module.zipCode.controller;

import com.challenge.michelfreitas.challenge.module.zipCode.service.IZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zipcode")
public class ZipCodeController {

    @Autowired
    private IZipCodeService zipCodeService;

    @GetMapping("/{zipCode}")
    public ResponseEntity<?> getByZipCode(@PathVariable String zipCode) {
        return ResponseEntity.ok(this.zipCodeService.getByZipCode(zipCode));
    }
}
