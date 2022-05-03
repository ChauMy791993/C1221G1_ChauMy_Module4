package com.codegym.service;


import com.codegym.repository.ISimpleDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleDictionaryServiceImpl implements ISimpleDictionaryService {

    @Autowired
    ISimpleDictionaryRepository iSimpleDictionaryRepository;

    @Override
    public String translate(String word) {
        return iSimpleDictionaryRepository.translate(word);
    }
}
