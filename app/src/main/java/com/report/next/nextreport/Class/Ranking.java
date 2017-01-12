package com.report.next.nextreport.Class;

/**
 * Created by TimotiusEk on 1/11/2017.
 */

public class Ranking {

    private int rank;
    private String name;
    private String departments;
    private String location;
    private int points;
    private int clients;

    public Ranking(int rank, String name, String departments, String location, int points, int clients) {
        this.rank = rank;
        this.name = name;
        this.departments = departments;
        this.location = location;
        this.points = points;
        this.clients = clients;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
