package com.bank.fingerprints.service.Impl;

import com.bank.fingerprints.entity.FingerprintResponse;
import com.bank.fingerprints.service.FingerPrintService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public class FingerPrintServiceImpl implements FingerPrintService
{
    @Override
    public Boolean existsByDocument(String document)
    {
        return true;
    }

    @Override
    public Single<FingerprintResponse> validateFingerPrint(String document)
    {
        FingerprintResponse response = new FingerprintResponse("Core", true);
        return existsByDocument(document) == true ? Single.just(response) :  null ;
    }
}
