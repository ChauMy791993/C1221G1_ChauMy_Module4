package com.codegym.service;


import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterServiceImpl implements ICurrencyConverterService {
    @Override
    public String converter(String usd) {
        String result;
        if (usd.equals("") || !usd.matches("^\\d+$")){
            result = "khong hop le";
        }else {
            result = String.valueOf((Double.parseDouble(usd)*23000));
        }
        return result;
    }
}
