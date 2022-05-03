package com.codegym.repository;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleDictionaryRepositoryImpl implements ISimpleDictionaryRepository {

    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào!");
        dictionary.put("where", "ở đâu");
        dictionary.put("good","tốt !");
        dictionary.put("never","không bao giờ");
    }

    @Override
    public String translate(String word) {
        if (dictionary.get(word) == null){
            return "not found";
        }else {
            return dictionary.get(word);
        }
    }
}
