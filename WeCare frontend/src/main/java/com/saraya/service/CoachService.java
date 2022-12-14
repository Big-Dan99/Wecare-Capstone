package com.saraya.service;

import com.saraya.DTO.CoachDto;
import com.saraya.DTO.LoginDto;
import com.saraya.DTO.UserDto;
import com.saraya.entity.CoachEntity;
import com.saraya.entity.UserEntity;
import com.saraya.exception.ExceptionConstant;
import com.saraya.exception.WecareException;
import com.saraya.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    CoachRepository coachRepo;

    public String createCoach(CoachDto coachDTO){
//        This method is used to create a new coach. Invoke save() method of coach repository and return coach id.
        CoachEntity coachEnt = new CoachEntity(coachDTO.getName(), coachDTO.getPassword(), coachDTO.getDateOfBirth(),coachDTO.getMobileNumber(),coachDTO.getGender(),coachDTO.getSpeciality());

        coachRepo.save(coachEnt);

        return coachEnt.getCoachId() ;

    }

    public boolean loginCoach(LoginDto loginDTO) throws WecareException{
//        This method is used to login by an existing coach. Invoke findByCoachId() method of coach repository.
//        If coach is available then compare passwords and return result otherwise
//        throw WecareException with message COACH_NOT_FOUND

        CoachEntity coachEnt = new CoachEntity( loginDTO.getId(), loginDTO.getPassword());

//        This method is used to find user details using given user id.
        Optional<CoachEntity> coach = coachRepo.findByCoachId(coachEnt.getCoachId());

        CoachEntity coachEnt2 = null;

        if (coach.isPresent()) {
            coachEnt2 = coach.get();

        }else {
            throw new WecareException(ExceptionConstant.COACH_NOT_FOUND.toString());
        }

        if (Objects.equals(coachEnt2.getPassword(), coachEnt.getPassword())) {
            return true;
        }
        return false;

    }

    public CoachDto getCoachProfile(String coachId){
//        This method is used to send coach DTO for a given coach id.
//        Invoke findByCoachId() method of coach repository.
//        If coach is available then send coach DTO otherwise send null.

        Optional<CoachEntity> coach = coachRepo.findByCoachId(coachId);

        CoachEntity coachEnt = null;

        if (coach.isPresent()) {
            coachEnt = coach.get();
        }

        CoachDto coachDto = new CoachDto(coachEnt.getCoachId(),coachEnt.getPassword(), coachEnt.getName(), coachEnt.getDateOfBirth(), coachEnt.getGender(),coachEnt.getMobileNumber(),coachEnt.getSpeciality());

        return coachDto;
    }


        public List<CoachDto> showAllCoaches(){
        //        This method is used to send list of all coach DTO. Invoke findAll() method of coach repository.
            List<CoachEntity> listcoachent = coachRepo.findAll();

            List<CoachDto> listcoachDto = new ArrayList<>();

            for (CoachEntity coachEnt: listcoachent) {
                CoachDto coachDto = new CoachDto(coachEnt.getCoachId(),coachEnt.getPassword(), coachEnt.getName(), coachEnt.getDateOfBirth(), coachEnt.getGender(),coachEnt.getMobileNumber(),coachEnt.getSpeciality());
                listcoachDto.add(coachDto);

            }
                   return  listcoachDto;
        }


}
