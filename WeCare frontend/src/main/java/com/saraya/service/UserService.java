package com.saraya.service;

import com.fasterxml.jackson.core.JsonParser;
import com.saraya.DTO.LoginDto;
import com.saraya.DTO.UserDto;
import com.saraya.entity.UserEntity;
import com.saraya.exception.ExceptionConstant;
import com.saraya.exception.WecareException;
import com.saraya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

//      This method is used to create a new user. Invoke save() method of user repository and return user id.
    public String createUser(UserDto userDTO){

        UserEntity userEnt = new UserEntity(userDTO.getEmail(),userDTO.getName(),userDTO.getPassword(),userDTO.getGender(), userDTO.getDateOfBirth(), userDTO.getMobileNumber(),userDTO.getCity(),userDTO.getCountry(),userDTO.getState(),userDTO.getPincode());

        userRepo.save(userEnt);

        return userEnt.getUserId();
    }

//          This method is used to login by an existing user. Invoke findByUserId() method of user repository.
//        If user is available then compare passwords and return result
//        otherwise throw WecareException with message USER_NOT_FOUND.
    public boolean loginUser(LoginDto loginDTO) throws WecareException {
        UserEntity userEnt = new UserEntity( loginDTO.getId(), loginDTO.getPassword());

//        This method is used to find user details using given user id.
        Optional<UserEntity> user = userRepo.findByUserId(userEnt.getUserId());

        UserEntity userEnt2 ;

        if (user.isPresent()) {
            userEnt2 = user.get();

        }else {
            throw new WecareException(ExceptionConstant.USER_NOT_FOUND.toString());
        }


            if (Objects.equals(userEnt2.getPassword(), userEnt.getPassword())) {
                return true;
            }
            return false;
    }

    public UserDto getUserProfile(String userId){

//        This method is used to send user DTO for a given user id.
//        Invoke findByUserId() method of user repository.
//        If user is available then send user DTO otherwise send null

        //        This method is used to find user details using given user id.
        Optional<UserEntity> user = userRepo.findByUserId(userId);

        UserEntity userEnt = null;
//        UserDto userDto = null;

        if (user.isPresent()) {
            userEnt = user.get();
        }


        UserDto userDto = new UserDto(userEnt.getUserId(), userEnt.getMobileNumber(),userEnt.getPassword(), userEnt.getCity(), userEnt.getName(), userEnt.getDateOfBirth(), userEnt.getGender(), userEnt.getPincode(),  userEnt.getCountry(), userEnt.getEmail(), userEnt.getState());

        return userDto;
    }

}
