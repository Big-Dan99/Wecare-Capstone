package com.saraya.controller;

import com.saraya.DTO.BookingDto;
import com.saraya.entity.BookingEntity;
import com.saraya.exception.ExceptionConstant;
import com.saraya.exception.WecareException;
import com.saraya.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRestController {

    @Autowired
    BookService bookService;

    @PostMapping("/users/{userId}/booking/{coachId}")
    public ResponseEntity<Boolean> bookAppointment(@PathVariable String userId, @PathVariable String coachId, @RequestParam String slot,@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date  appointmentDate) throws WecareException {

//        This method is used to schedule an appointment for a given with a particular coach at specified date and slot,
//        if booking is successfull then return booking status with status OK otherwise return exception message with status NOT_FOUND.
//        if(!bookService.bookAppointment(userId,coachId,dateOfAppointment,slot)){
//
//            ResponseEntity.ok(false);
//        }
        return ResponseEntity.ok(bookService.bookAppointment(userId,coachId,appointmentDate,slot));
    }

    @PutMapping("/reschedule/{bookingId}")
    public ResponseEntity<Boolean> rescheduleAppointment( @PathVariable Integer bookingId, @RequestParam String slot, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate){
//        This method is used to re-schedule an appointment for a given booking id at specified date and slot,
//        if re-booking is successfull then return booking status with status OK otherwise return exception message with status NOT_FOUND.

       return ResponseEntity.ok(bookService.rescheduleAppointment(bookingId,appointmentDate,slot));
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Integer bookingId){
//        This method is used to cancel an appointment for a given booking id and return void status with status OK.
        bookService.cancelAppointment(bookingId);
        return ResponseEntity.noContent().build();
    }


}
