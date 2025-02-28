package com.challenge.michelfreitas.challenge.module.zipCode.controller;

import com.challenge.michelfreitas.challenge.module.zipCode.service.IZipCodeService;
import com.challenge.michelfreitas.challenge.shared.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("zipcode")
@CrossOrigin(origins = "*")
public class ZipCodeController {

    @Autowired
    private IZipCodeService zipCodeService;

    @GetMapping("/{zipCode}")
    public ResponseEntity<ApiResponse> getByZipCode(@PathVariable String zipCode) {
        var result = this.zipCodeService.getByZipCode(zipCode);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping("/list-logs")
    public ResponseEntity<ApiResponse> getLogsByUf(@RequestParam String uf) {
        var result = this.zipCodeService.getZipCodeLogByUf(uf);
        return ResponseEntity.ok(new ApiResponse(result));
    }
}
