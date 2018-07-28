package com.spark.arabic.controller;

import com.spark.arabic.collection.Senators;
import com.spark.arabic.repository.SenatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SenatorController {

    @Autowired
    SenatorsRepository senatorsRepository;

    @GetMapping     ("/senators/name/{firstname}/{lastname}")
    public Senators getSenatorByFirstAndLastName(@PathVariable  String firstname, @PathVariable String lastname) {
        List<Senators> senators = senatorsRepository.findByPersonFirstnameAndPersonLastname(firstname, lastname);
        return senators.get(0);
    }

    @GetMapping ("/senators/all")
    public List<Senators> getAll() {
        return senatorsRepository.findAll();
    }


}
