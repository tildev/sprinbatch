package com.tildev.batch.jobs.job1.domain;

import java.io.Serializable;
import java.util.Date;

public class Data1 implements Serializable {

    private static final long serialVersionUID = 7759934838896324764L;

    private String id;

    private String name;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data1 [id=" + id + ", name=" + name + ", date=" + date + "]";
    }

}
