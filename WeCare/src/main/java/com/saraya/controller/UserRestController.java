package com.saraya.controller;

import com.saraya.DTO.BookingDto;
import com.saraya.DTO.LoginDto;
import com.saraya.DTO.UserDto;
import com.saraya.exception.ExceptionConstant;
import com.saraya.exception.WecareException;
import com.saraya.service.BookService;
import com.saraya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//
//        return "signup_form";
//    }
//@GetMapping("/readTodo")
//public List<Todo> GetAllTodo() {
//    return repo.findAll();
//}
//

    @PostMapping(value = "/saveUser" )
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDTO, Errors errors) {
        String response = "";
        if (errors.hasErrors())
        {
            response  = errors.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));


            return ResponseEntity.ok(response);
        }
        else
        {
         response = userService.createUser(userDTO);
            return ResponseEntity.ok(response);
        }
    }

//This method is used to login by an existing user,
// if credentials are correct then true is sent otherwise false is sent with status code OK.
    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody LoginDto loginDTO) throws Exception {


        if (!userService.loginUser(loginDTO)) {
            ResponseEntity.ok(false);

        }
            return ResponseEntity.ok(userService.loginUser(loginDTO) );

    }

    @GetMapping("/usr/{userId}")
    public ResponseEntity<UserDto> getUserProfile(@PathVariable String userId){

//        This method is used to send user DTO for a given user id with status OK.

        return ResponseEntity.ok(userService.getUserProfile(userId));

    }
        @GetMapping("/usr/appointments/{userId}")
        public List<BookingDto> showMyAppointments(@PathVariable String userId){
//      This method is used to send list of booking DTO for a given user id.
           return bookService.findBookingByUserId(userId);
    }

}
