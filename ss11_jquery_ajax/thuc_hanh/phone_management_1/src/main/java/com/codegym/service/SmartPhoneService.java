package com.codegym.service;

import com.codegym.model.Smartphone;
import com.codegym.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {

    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {iSmartPhoneRepository.deleteById(id);
    }
}
