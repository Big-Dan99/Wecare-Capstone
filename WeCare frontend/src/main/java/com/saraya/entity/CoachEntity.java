package com.saraya.entity;

import com.saraya.utility.CoachIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Locale;

@Entity
public class CoachEntity {

    @Id
    @GenericGenerator(name = "coach_id", strategy = "com.saraya.utility.CoachIdGenerator")
    @GeneratedValue(generator = "coach_id")
    private String coachId;

    private String name;
    private String password;
    private char gender;
    private LocalDate dateOfBirth;
    private long mobileNumber;
    private String speciality;

    public CoachEntity() {
    }

    public CoachEntity(String coachId, String name, String password, char gender, LocalDate dateOfBirth, long mobileNumber, String speciality) {
        this.coachId = coachId;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.speciality = speciality;
    }

    public CoachEntity(String name, String password, LocalDate dateOfBirth, long mobileNumber, char gender, String speciality) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.speciality = speciality;
    }

    public CoachEntity(String coachId, String password) {
        this.coachId = coachId;
        this.password = password;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        coachId = coachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "CoachEntity{" +
                "CoachId='" + coachId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", mobileNumber=" + mobileNumber +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
