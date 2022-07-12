package com.example.kt_md4.service.impl;

import com.example.kt_md4.model.Country;
import com.example.kt_md4.repository.CountryRepository;
import com.example.kt_md4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
    countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
    countryRepository.deleteById(id);
    }
}
