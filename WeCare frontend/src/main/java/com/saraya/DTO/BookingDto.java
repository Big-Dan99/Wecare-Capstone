package com.saraya.DTO;

import java.time.LocalDate;
import java.util.Date;

public class BookingDto {

//    DataType	Variable
//    int	bookingId
//    String	userId
//    String	coachId
//    LocalDate	appointmentDate
//
//    char	slot

    private int	bookingId;
    private String	userId;
    private String	coachId;
    private Date appointmentDate;
    private String	slot;

    public BookingDto() {
    }

    public BookingDto(int bookingId, String userId, String coachId, Date appointmentDate, String slot) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.coachId = coachId;
        this.appointmentDate = appointmentDate;
        this.slot = slot;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "bookingId=" + bookingId +
                ", userId='" + userId + '\'' +
                ", coachId='" + coachId + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", slot=" + slot +
                '}';
    }
}
