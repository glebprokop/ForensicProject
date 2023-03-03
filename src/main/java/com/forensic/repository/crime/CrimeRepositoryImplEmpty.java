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
    public List<Crime> foundAll() {
        return null;
    }

    @Override
    public Optional<Crime> foundById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean add(Crime crime) {
        return false;
    }

    @Override
    public Optional<Crime> update(long id, Crime newCrime) {
        return Optional.empty();
    }

    @Override
    public List<Long> getAllId() {
        return null;
    }

    @Override
    public List<Crime> getCrimesForMonth(int year, int month) {
        return null;
    }

    @Override
    public List<Crime> getCrimesForArticle(long criminalCodeArticle) {
        return null;
    }
}
