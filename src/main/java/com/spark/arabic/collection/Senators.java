package com.spark.arabic.collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "senators")
public class Senators {

    @Id
    public String id;

    String party;
    String phone;
    String state;
    String website;

    @JsonProperty("person")
    Person person;

    String description;

    public  Senators() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Senators{" +
                "id='" + id + '\'' +
                ", person=" + person +
                ", description='" + description + '\'' +
                '}';
    }
}
