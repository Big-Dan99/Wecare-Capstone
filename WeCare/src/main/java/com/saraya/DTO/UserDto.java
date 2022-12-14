package com.saraya.DTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

public class UserDto {


    private String	UserId;

    @Size(min = 5, max = 10, message = "Cannot be null, minimum length should be 5 and maximum length should be 10." )
    private String	password;

    @Size(min = 3, max = 50, message = "Cannot be null, minimum length should be 3 and maximum length should be 50." )
    private String	name;

    private Date dateOfBirth;

    private char	gender;


    @NotNull( message = "Cannot be null, minimum length should be 10 and maximum length should be 10.")
    private long	mobileNumber;

    @Email(message = "Should be a valid email, please check !")
    private String	email;



    @NotNull( message = "Cannot be null, minimum length should be 6 and maximum length should be 6.")
    private int	pincode;

    @Size(min = 3, max = 20, message = "Cannot be null, minimum length should be 3 and maximum length should be 20." )
    private String	city;

    @Size(min = 3, max = 20, message = "Cannot be null, minimum length should be 3 and maximum length should be 20." )
    private String	state;

    @Size(min = 3, max = 20, message = "Cannot be null, minimum length should be 3 and maximum length should be 20." )
    private String	country;

    public UserDto() {
    }

    public UserDto(String userId, String password, String name, Date dateOfBirth, char gender, long mobileNumber, String email, int pincode, String city, String state, String country) {
        UserId = userId;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public UserDto(String userId, long mobileNumber, String password, String city, String name, Date dateOfBirth, char gender, int pincode, String country, String email, String state) {
        UserId = userId;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "UserId='" + UserId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
