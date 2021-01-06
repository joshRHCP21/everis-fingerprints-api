package com.bank.fingerprints.controller;

import com.bank.fingerprints.entity.Fingerprint;
import com.bank.fingerprints.entity.FingerprintResponse;
import com.bank.fingerprints.service.FingerPrintService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core/fingerprints")
public class FingerprintController
{
    @Autowired
    FingerPrintService fingerPrintService;

    @PostMapping("/validate")
    public Single<FingerprintResponse> validateFingerPrintByDocument(@RequestBody Fingerprint fingerPrint)
    {
        return fingerPrintService.validateFingerPrint(fingerPrint.getDocument());
    }
}
