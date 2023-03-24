package com.forensic.service.crime;

import com.forensic.entity.crime.Crime;
import com.forensic.repository.crime.CrimeRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CrimeServiceImpl implements CrimeService{

    CrimeRepository repository;

    public CrimeServiceImpl(CrimeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Crime> findAll() {
        return repository.findAll();
    }

    @Override
    public Crime findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Crime> findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Crime delete(Long id) {
        return repository.delete(id);
    }

    @Override
    public Crime create(Crime object) {
        return null;
    }

    @Override
    public Crime update(Crime object) {
        return repository.update(object);
    }

    @Override
    public List<Crime> getCrimesForMonth(Integer year, Integer month) {
        return repository.getCrimesForMonth(year, month);
    }

    @Override
    public List<Crime> getCrimesForArticle(Long criminalCodeArticle) {
        return repository.getCrimesForArticle(criminalCodeArticle);
    }

    @Override
    public void deleteCrimesBeforeDate(Timestamp deleteDate) {
        repository.deleteCrimesBeforeDate(deleteDate);

    }

    @Override
    public List<Crime> searchByParams(Map<String, String> requestParams) {
        return repository.searchByParams(requestParams);
    }
}
