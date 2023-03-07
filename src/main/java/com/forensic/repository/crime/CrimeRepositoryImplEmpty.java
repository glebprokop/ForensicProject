package com.forensic.repository.crime;

import com.forensic.entity.crime.Crime;

import java.util.List;
import java.util.Optional;

/**
 * Empty (for now) realization of the {@link CrimeRepository} interface
 */
@Deprecated
public class CrimeRepositoryImplEmpty implements CrimeRepository{

    @Override
    public List<Crime> findAll() {
        return null;
    }

    @Override
    public Crime findById(Long id) {
        return null;
    }

    @Override
    public Optional<Crime> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Crime delete(Long id) {
        return null;
    }

    @Override
    public Crime add(Crime crime) {
        return null;
    }

    @Override
    public Optional<Crime> update(Long id, Crime newCrime) {
        return Optional.empty();
    }

    @Override
    public List<Long> getAllId() {
        return null;
    }

    @Override
    public List<Crime> getCrimesForMonth(Integer year, Integer month) {
        return null;
    }

    @Override
    public List<Crime> getCrimesForArticle(Long criminalCodeArticle) {
        return null;
    }
}
