package com.forensic.controller.crime;

import com.forensic.controller.AbstractRestController;
import com.forensic.dto.CrimeRequest;
import com.forensic.entity.crime.Crime;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface AbstractCrimeRestController extends AbstractRestController<Crime> {

    ResponseEntity<List<Crime>> searchByParam(Map<String, String> requestParams);

    ResponseEntity<List<Crime>> searchByMonth(Integer year, Integer month);

    ResponseEntity<List<Crime>> searchByArticle(Long criminalCodeArticle);

    ResponseEntity<List<Crime>> deleteBeforeDate(Timestamp deleteDate);
}
