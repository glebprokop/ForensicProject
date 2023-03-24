package com.forensic.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AbstractRestController<T> {

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(Long id);

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t);

    ResponseEntity<T> deleteById(Long id);
}
