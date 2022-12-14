package com.saraya.repository;

import com.saraya.entity.BookingEntity;
import com.saraya.entity.CoachEntity;
import com.saraya.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookingEntity, Integer> {

//This method is used to find booking details using given user id.
    Optional<BookingEntity> findByUserId(String userId);



//    This method is used to find list of bookings using given user id which are after current date.
    List<BookingEntity> findBookingByUserId(String userId);

//    This method is used to find list of bookings using given coach id which are after current date.
    List<BookingEntity> findBookingByCoachId(String coachId);

//    This method is used to find booking details using given user id, date of appointment and slot.
    @Query("select b from BookingEntity b where b.userId = ?1 and b.appointmentDate =?2 and b.slot = ?3")
    BookingEntity findAllBooking(String userId, Date appointmentDate, String slot);
}
