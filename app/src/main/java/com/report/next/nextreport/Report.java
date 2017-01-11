package com.report.next.nextreport;

/**
 * Created by TimotiusEk on 1/11/2017.
 */

public class Report {


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * TODO: ganti datatype jadi date
     */
    private String title;
    private String description;
    private String status;
    private String date;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private String month;

    public Report(String date, String description, String title, String status, String month) {
        this.date = date;
        this.description = description;
        this.title = title;
        this.status = status;
        this.month = month;
    }
}
