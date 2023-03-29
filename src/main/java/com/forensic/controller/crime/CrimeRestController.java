package com.forensic.controller.crime;

import com.forensic.entity.crime.Crime;
import com.forensic.repository.crime.CrimeRepository;
import com.forensic.service.crime.CrimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/crime")
public class CrimeRestController implements AbstractCrimeRestController{

    CrimeService service;

    public CrimeRestController(CrimeService service) {
        this.service = service;
    }

    @Override
    @GetMapping("")
    public ResponseEntity<List<Crime>> findAll() {
        List<Crime> objects;

        objects = service.findAll();

        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Crime> findById(@PathVariable Long id) {
        Crime object = service.findById(id);

        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Crime> create(@RequestBody Crime crime) {
        Crime createdObject = service.create(crime);

        return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("")
    public ResponseEntity<Crime> update(@RequestBody Crime crime) {
        Crime updatedObject = service.update(crime);

        return new ResponseEntity<>(updatedObject, HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Crime> deleteById(@PathVariable Long id) {
        Crime deletedObject = service.delete(id);

        return new ResponseEntity<>(deletedObject, HttpStatus.OK);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<List<Crime>> searchByParam(@RequestParam Map<String, String> requestParams) {
        List<Crime> objects = service.searchByParams(requestParams);

        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @Override
    @GetMapping("/search-month")
    public ResponseEntity<List<Crime>> searchByMonth(@RequestParam Integer year,
                                                     @RequestParam Integer month) {
        List<Crime> objects = service.getCrimesForMonth(year, month);

        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @Override
    @GetMapping("/search-article")
    public ResponseEntity<List<Crime>> searchByArticle(@RequestParam Long criminalCodeArticle) {
        List<Crime> objects = service.getCrimesForArticle(criminalCodeArticle);

        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("")
    public ResponseEntity<List<Crime>> deleteBeforeDate(@RequestParam Timestamp deleteDate) {
        service.deleteCrimesBeforeDate(deleteDate);

        List<Crime> updatedObjects = service.findAll();

        return new ResponseEntity<>(updatedObjects, HttpStatus.OK);
    }
}
