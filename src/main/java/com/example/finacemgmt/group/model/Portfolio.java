package com.example.finacemgmt.group.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Portfolio {

    @Id
    public String _id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date creationDate;

    public Portfolio() {
        // Default constructor
        // Set the creationDate to the current date and time when a new instance is created
        this.creationDate = new Date();
    }

    public Portfolio(String _id, Date creationDate) {
        this._id = _id;
        this.creationDate = creationDate;
    }

    // Getters and setters...

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
