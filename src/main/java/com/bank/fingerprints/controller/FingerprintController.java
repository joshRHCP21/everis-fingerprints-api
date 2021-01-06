package com.bank.fingerprints.controller;

import com.bank.fingerprints.entity.Fingerprint;
import com.bank.fingerprints.entity.FingerprintResponse;
import com.bank.fingerprints.service.FingerPrintService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core/fingerprints")
@Api("/core/fingerprints")
public class FingerprintController
{
    @Autowired
    FingerPrintService fingerPrintService;

    @PostMapping("/validate")
    @ApiOperation(value = "Validate if people are registered by their fingerprint", notes = "Retrieving a Fingerprint Response", response = FingerprintResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FingerprintResponse.class)
    })
    public Single<FingerprintResponse> validateFingerPrintByDocument(@RequestBody Fingerprint fingerPrint)
    {
        return fingerPrintService.validateFingerPrint(fingerPrint.getDocument());
    }
}
