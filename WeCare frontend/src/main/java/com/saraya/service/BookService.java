package com.saraya.service;

import com.saraya.DTO.BookingDto;
import com.saraya.DTO.CoachDto;
import com.saraya.entity.BookingEntity;
import com.saraya.entity.CoachEntity;
import com.saraya.entity.UserEntity;
import com.saraya.exception.ExceptionConstant;
import com.saraya.exception.WecareException;
import com.saraya.repository.BookRepository;
import com.saraya.repository.CoachRepository;
import com.saraya.repository.UserRepository;
import com.saraya.utility.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;

    @Autowired
    CoachRepository cRepo;

    @Autowired
    UserRepository uRepo;

    @Autowired
    MailUtility mailUtility;



    public boolean bookAppointment(String userId, String coachId, Date appointmentDate, String slot)  throws WecareException{
//     This method is used to reschedule appointment for a given booking id. Invoke findAllBookings() method of book repository.
//     If user is not having any specified booking at given slot and date then save booking details in book repository and invoke sendSchedulingEmail()
//     method of mail utility class and return true otherwise throw WecareException  with message BOOKING_ALREADY_EXISTS.

        //    This method is used to find booking details using given user id, date of appointment and slot.
        BookingEntity booking = bookRepo.findAllBooking(userId, appointmentDate, slot);

            BookingEntity newbooking = new BookingEntity( userId,coachId, appointmentDate,slot);
//        BookingEntity booking1 = new BookingEntity(booking.getBookingId(),booking.getUserId(),booking.getCoachId(),booking.getSlot(),booking.getAppointmentDate());

        Optional<UserEntity> user = uRepo.findByUserId(userId);
        UserEntity userEnt = null;


        if (user.isPresent()) {
            userEnt = user.get();
        }

        Optional<CoachEntity> coach = cRepo.findByCoachId(coachId);

        CoachEntity coachEnt = null;

        if (coach.isPresent()) {
            coachEnt = coach.get();
        }


        if (booking != null) {
            throw new WecareException(ExceptionConstant.BOOKING_ALREADY_EXISTS.toString());
        }else {
            bookRepo.save(newbooking);

            mailUtility.sendSchedulingEmail(userEnt.getName(), coachEnt.getName(),userEnt.getEmail(), newbooking.getBookingId(), newbooking.getSlot(), newbooking.getAppointmentDate());
            return true;
        }
//
//
    }
    public boolean rescheduleAppointment(Integer bookingId, Date appointmentDate, String slot){

//     This method is used to reschedule appointment for a given booking id. Invoke getOne() method of book repository,
//     then invoke findAllBookings() method of book repository. If user is not having any specified booking at new
//     slot and date then save new booking details in book repository and invoke sendReschedulingEmail()
//     method of mail utility class and return true otherwise throw WecareException  with message BOOKING_ALREADY_EXISTS.
               BookingEntity book = bookRepo.getReferenceById(bookingId);

//        //    This method is used to find booking details using given user id, date of appointment and slot.
               BookingEntity booking = bookRepo.findAllBooking(book.getUserId(), appointmentDate, slot );
//
        BookingEntity newbooking = new BookingEntity( book.getUserId(),book.getCoachId(), appointmentDate,slot);


        Optional<UserEntity> user = uRepo.findByUserId(book.getUserId());
        UserEntity userEnt = null;


        if (user.isPresent()) {
            userEnt = user.get();
        }

        Optional<CoachEntity> coach = cRepo.findByCoachId(book.getCoachId());

        CoachEntity coachEnt = null;

        if (coach.isPresent()) {
            coachEnt = coach.get();
        }

        if (booking != null) {
            return false;
        }else {
            bookRepo.save(newbooking);
            mailUtility.sendReschedulingEmail(userEnt.getName(), coachEnt.getName(),userEnt.getEmail(), newbooking.getBookingId(), newbooking.getSlot(), newbooking.getAppointmentDate());
//            mailUtility.sendReschedulingEmail();
            return true;
        }

//

    }
    public void cancelAppointment(Integer bookingId){
////        This method is used to cancel appointment for a given booking id. Invoke sendCancellingEmail() method of mail utility class
////        and then invoke deleteById() method of book repository. Then invoke findByBookingId() method of book service.
        BookingEntity book = bookRepo.getReferenceById(bookingId);

        Optional<UserEntity> user = uRepo.findByUserId(book.getUserId());
        UserEntity userEnt = null;


        if (user.isPresent()) {
            userEnt = user.get();
        }

        Optional<CoachEntity> coach = cRepo.findByCoachId(book.getCoachId());

        CoachEntity coachEnt = null;

        if (coach.isPresent()) {
            coachEnt = coach.get();
        }

        mailUtility.sendCancellingEmail(userEnt.getName(), coachEnt.getName(),userEnt.getEmail(), book.getBookingId(), book.getSlot(), book.getAppointmentDate());
        bookRepo.deleteById(book.getBookingId());

//    mailUtility.sendCancellingEmail();
    }
//
    public BookingDto findByBookingId(Integer bookingId){

//        This  method is used to return appointment for a given booking id. Invoke getOne() method of book repository.
        BookingEntity book = bookRepo.getReferenceById(bookingId);

        BookingDto newbook = new BookingDto(book.getBookingId(), book.getUserId(), book.getCoachId(), book.getAppointmentDate(), book.getSlot());

        return newbook;
    }
//
    public List<BookingDto> findBookingByUserId(String userId){

//        This method is used to return list of upcoming  appointments only for a given user id.
//        Invoke findBookingByUserId() method of book repository.

        List<BookingEntity> listbooking = bookRepo.findBookingByUserId(userId);

        List<BookingDto> listbookDto = new ArrayList<>();

        for (BookingEntity bookEnt: listbooking) {
            BookingDto bookDto = new BookingDto(bookEnt.getBookingId(), bookEnt.getUserId(), bookEnt.getCoachId(), bookEnt.getAppointmentDate(), bookEnt.getSlot());
            listbookDto.add(bookDto);

        }
        return  listbookDto;
    }



    public  List<BookingDto> findBookingByCoachId(String coachId){
//        This method is used to return list of upcoming appointments only for a given coach id.
//        Invoke findBookingByCoachId() method of book repository.
        List<BookingEntity> listbooking = bookRepo.findBookingByCoachId(coachId);

        List<BookingDto> listbookingDto = new ArrayList<>();

        for (BookingEntity bookEnt: listbooking) {
            BookingDto bookDto = new BookingDto(bookEnt.getBookingId(), bookEnt.getUserId(), bookEnt.getCoachId(), bookEnt.getAppointmentDate(), bookEnt.getSlot());
            listbookingDto.add(bookDto);

        }

        return  listbookingDto;
    }

}
