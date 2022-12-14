package com.saraya.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;


    private  String userId;


    private String coachId;

    private String slot;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;


    public BookingEntity() {
    }

    public BookingEntity(Integer bookingId, String userId, String coachId, String slot, Date appointmentDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.coachId = coachId;
        this.slot = slot;
        this.appointmentDate = appointmentDate;
    }

    public BookingEntity(String userId, String coachId, Date appointmentDate, String slot) {
        this.userId = userId;
        this.coachId = coachId;
        this.slot = slot;
        this.appointmentDate = appointmentDate;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", coachId=" + coachId +
                ", slot='" + slot + '\'' +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
