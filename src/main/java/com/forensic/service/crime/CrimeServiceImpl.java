package com.forensic.service.crime;

import com.forensic.entity.crime.Crime;
import com.forensic.repository.crime.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CrimeServiceImpl implements CrimeService{

    @Autowired
    CrimeRepository repository;

    @Override
    public List<Crime> foundAll() {


        return repository.findAll();
    }

    @Override
    public Crime foundById(long id) {
        return repository.findById(id);
    }

    @Override
    public Crime deleteById(long id) {
        return repository.delete(id);
    }

    @Override
    public Crime add(Crime crime) {
        return repository.add(crime);
    }

    @Override
    public Optional<Crime> update(long id, Crime newCrime) {
        return repository.update(id, newCrime);
    }

    @Override
    public List<Long> getAllId() {
        return repository.getAllId();
    }

    @Override
    public List<Crime> getCrimesForMonth(int year, int month) {
        return repository.getCrimesForMonth(year, month);
    }

    @Override
    public List<Crime> getCrimesForArticle(long criminalCodeArticle) {
        return repository.getCrimesForArticle(criminalCodeArticle);
    }
}
