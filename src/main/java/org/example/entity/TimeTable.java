package org.example.entity;

public class TimeTable {
    String subject_name;
    int subject_number;
    int day_of_week;
    String pteacher_surname;

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getSubject_number() {
        return subject_number;
    }

    public void setSubject_number(int subject_number) {
        this.subject_number = subject_number;
    }

    public int getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(int day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getPteacher_surname() {
        return pteacher_surname;
    }

    public void setPteacher_surname(String pteacher_surname) {
        this.pteacher_surname = pteacher_surname;
    }
}
