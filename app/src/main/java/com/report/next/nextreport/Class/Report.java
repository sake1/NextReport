package com.report.next.nextreport.Class;

/**
 * Created by TimotiusEk on 1/11/2017.
 */

public class Report {

    /**
     * TODO: ganti datatype jadi date
     */
    private String title;
    private String description;
    private ReportStatus status;
    private String date;
    private String month;

    public Report(String date, String month,  String title, String description, ReportStatus status) {
        this.date = date;
        this.description = description;
        this.title = title;
        this.status = status;
        this.month = month;
    }

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

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
