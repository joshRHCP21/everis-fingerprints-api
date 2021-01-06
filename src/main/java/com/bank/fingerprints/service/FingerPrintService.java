package com.bank.fingerprints.service;

import com.bank.fingerprints.entity.FingerprintResponse;
import io.reactivex.Single;

public interface FingerPrintService
{
    Boolean existsByDocument(String document);
    Single<FingerprintResponse> validateFingerPrint(String document);
}
