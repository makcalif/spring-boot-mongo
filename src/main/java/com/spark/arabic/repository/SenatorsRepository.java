package com.spark.arabic.repository;

import com.spark.arabic.collection.Senators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface SenatorsRepository extends MongoRepository <Senators, String>{

    //public Senators findOne (String description);
    public List<Senators> findByDescription (String description);

    //@Query(value = "{ 'person.firstname': ?0 }", fields = "{ 'person.firstname' : 1, 'person.lastname' : 1 }")
    public List<Senators> findByPersonFirstname(String firstname);

    public List<Senators> findByPersonFirstnameAndPersonLastname(String firstname, String lastname);
}
