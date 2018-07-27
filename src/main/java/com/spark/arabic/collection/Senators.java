package com.spark.arabic.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "senators")
public class Senators {

    @Id
    public String id;

    Person person;

    String description;

    public  Senators() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Senators{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
