package com.forensic.repository.crime;

import com.forensic.configuration.MainSpringConfigClass;
import com.forensic.entity.crime.Crime;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CrimeRepositoryImplTest {

    GenericApplicationContext context;

    CrimeRepository repository;

    Crime testCrime;

    @Before
    public void info(){
        testCrime = Crime.builder()
                .crimeDate(Timestamp.valueOf("1980-01-01 00:00:00"))
                .caseInvestigationNumber(010101)
                .description("Murder test crime")
                .criminalCodeArticleNumber(139)
                .policeRegNumber(123)
                .build();


        context = new AnnotationConfigApplicationContext(MainSpringConfigClass.class);

        repository = context.getBean("crimeRepositoryImpl", CrimeRepository.class);
    }

    @Test
    public void testFindAllWork(){
        List<Crime> testList = repository.foundAll();

        System.out.println(testList);

        assertNotNull(testList);
    }

    @Test
    public void testAllIdMethod(){
        List<Long> testId = repository.getAllId();

        System.out.println(testId);

        assertNotNull(testId);
    }

    @Test
    public void testFindOneWork(){
        List<Long> allId = repository.getAllId();

        if (allId.size() != 0){
            Optional<Crime> crime = repository.foundById(allId.get(0));

            System.out.println(crime.orElse(null));

            assertNotNull(crime.orElse(null));

        } else {
            throw new RuntimeException("Empty data base, add data to test!");
        }
    }

    @Test
    public void testDeleteById(){
        List<Long> allId = repository.getAllId();

        if (allId.size() != 0){
            long testId = allId.get(0);

            repository.deleteById(testId);

            assertNull(repository.foundById(testId));

        } else {
            throw new RuntimeException("Empty data base, add data to test!");
        }
    }

    @Test
    public void testAddCrime(){
        repository.add(testCrime);

        System.out.println(repository.foundAll());
    }

    @Test
    public void testUpdateCrime(){
        List<Long> allId = repository.getAllId();

        if (allId.size() != 0){
            long testId = allId.get(0);
            testCrime.setId(testId);

            repository.update(testId, testCrime);
            System.out.print(repository.foundById(testId));

            assertEquals(testCrime, repository.foundById(testId).get());

        } else {
            throw new RuntimeException("Empty data base, add data to test!");
        }
    }

    @Test
    public void testCrimesForMonthTrue(){
        int testYear = 1980;
        int testMonth = 1;

        List<Crime> crimes = repository.getCrimesForMonth(testYear, testMonth);
        repository.add(testCrime);

        int compareYear = crimes.get(0).getCrimeDate().getYear();
        int compareMonth = crimes.get(0).getCrimeDate().getMonth();

        assertEquals(testYear - 1900, compareYear);
        assertEquals(testMonth - 1, compareMonth);
    }

    @Test
    public void testCrimesForMonthFalse(){
        int testYear = 2023; // other year for test
        int testMonth = 1;

        List<Crime> crimes = repository.getCrimesForMonth(testYear, testMonth);
        repository.add(testCrime);

        int compareYear = crimes.get(0).getCrimeDate().getYear();
        int compareMonth = crimes.get(0).getCrimeDate().getMonth();

        assertNotEquals(122, compareYear); // use 122 as 2022 - 1900
    }

    @Test
    public void testCrimesForArticleTrue(){
        long testArticle = 139; //Murder in the Rep of Belarus

        List<Crime> crimes = repository.getCrimesForArticle(testArticle);

        long compareArticle = crimes.get(0).getCriminalCodeArticleNumber();

        assertEquals(testArticle, compareArticle);
    }

    @Test
    public void testCrimesForArticleFalse(){
        long testArticle = 256; //Illegal actions with weapon in the Rep of Belarus, no contains in DB
        int expectedListSize = 0;

        List<Crime> crimes = repository.getCrimesForArticle(testArticle);

        assertEquals(expectedListSize, crimes.size());
    }
}